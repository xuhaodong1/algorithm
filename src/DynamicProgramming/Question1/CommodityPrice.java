package DynamicProgramming.Question1;

import java.util.*;

/**
 * @Description
 * @auther nihao
 * @create 2019-12-28 20:11
 */
public class CommodityPrice {
    public static int buyNum; // 购买商品的数量

    public static int discountNum; // 优惠套参数

    public static Map<String, Integer> resultMap = new HashMap<>(); //记录每一次的结果

    public static List<Commodity> commodityList = new ArrayList<>();

    public static List<Discount> discountList = new ArrayList<>();

    public static void main(String[] args){
        inputData();
        ergodic(0);
        String key = "";
        for(int i = 0; i < commodityList.size(); i++){
            key += commodityList.get(i).num + ",";
        }
        for(int i = 0; i < commodityList.size(); i++){
            key += commodityList.get(i).num + ",";
        }
        System.out.println("价格为");
        System.out.println(resultMap.get(key));
    }

    public static void inputData(){
        Scanner input = new Scanner(System.in);
        //从控制台录入数据
        buyNum = input.nextInt();
        for(int i = 1; i <= buyNum; i++ ){
            Commodity commodity = new Commodity();
            commodity.setCode(input.nextInt());
            commodity.setNum(input.nextInt());
            commodity.setPrice(input.nextInt());
            commodityList.add(commodity);
        }
        discountNum = input.nextInt();
        for(int i = 1; i <= discountNum ; i++ ){
            int combinationNum = input.nextInt();
            Discount discount = new Discount();
            for(int j = 1; j <= combinationNum; j++){
                Commodity commodity = new Commodity();
                commodity.setCode(input.nextInt());
                commodity.setNum(input.nextInt());
                discount.getDiscount().add(commodity);
            }
            discount.setTotalPrice(input.nextInt());
            discountList.add(discount);
        }
    }

    public static void computedValue(){
        int min = 0; // 当前最小花费
        String putKey = "";
        for(Commodity commodity : commodityList){ //初始化min 则未没有优惠时
            putKey += commodity.getAssumeNum() + ",";
            min += commodity.getPrice() * commodity.getAssumeNum();
        }
        //讨论每一种优惠情况
        for(Discount discount : discountList){
            String key = ""; // 存储在HashMap里面的key
            for(Commodity originCommodity : commodityList) { // 找到优惠
                Commodity current = new Commodity();
                for(Commodity discountCommodity : discount.getDiscount()){
                    if(originCommodity.getCode() == discountCommodity.getCode()){
                        current = discountCommodity;
                        break;
                    }
                }
                if(current.getNum() > originCommodity.getAssumeNum()){
                    key += "0,";
                }else{
                    key += originCommodity.getAssumeNum() - current.getNum() + ",";
                }
            }
            if(resultMap.containsKey(key)){
                if(resultMap.get(key) + discount.getTotalPrice() < min){
                    min = resultMap.get(key) + discount.getTotalPrice();
                }
            }
        }
        resultMap.put(putKey, min);
    }

    private static void ergodic(int i){//i类商品
        //确定一个子问题，计算一次当前最小花费
        if(i >= buyNum){
            computedValue();
            return;
        }
        for(int j = 0; j <= commodityList.get(i).num; j++){ //commodityList.get(i).num表示第i类商品的最大数量
            commodityList.get(i).setAssumeNum(j); //记录第i类商品购买数量j的情况
            ergodic(i+1);//控制遍历所有的商品类
        }
    }
}