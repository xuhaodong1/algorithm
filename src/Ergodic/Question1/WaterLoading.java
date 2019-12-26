package Ergodic.Question1;

import java.util.Scanner;

/**
 * @Description
 * @auther nihao
 * @create 2019-12-26 18:39
 */
//先用8品脱的壶，把5品脱的空壶灌满，然后用5品脱的壶把3品脱的空壶灌满，
//然后将3品脱的壶倒到8品脱的壶中；接着将5品脱的壶剩下的2品脱倒空到3
//品脱的壶中。然后再将5品脱的壶灌满，再将5品脱向3品脱的壶中倒水，直
//到灌满3品脱的壶。这时，5品脱的壶中，将含有精确的4品脱水。
public class WaterLoading {
    //倒水的壶不能同时倒两次
    public static PotNode potNode8;
    public static PotNode potNode5;
    public static PotNode potNode3;
    public static int count = 0;

    public static PotNode pull;
    public static PotNode push;
    public static PotNode nothing;

    public static void main(String[] args) {
        initPotNodes();
        while(true){
            if(pull == null && push == null){
                potNode3.load(potNode3.getBiggerPot());
                pull = potNode3;
                push = potNode8;
                nothing = potNode5;
                continue;
            }
            if( nothing.getSmallerPot() == pull ){
                nothing.load(pull);
                push = pull;
                pull = nothing;
                nothing = nothing.getBiggerPot();
            }else{
                nothing.load(push);
                nothing = nothing.getBiggerPot();
                pull = push;
                push = nothing;
            }

//            if(potNode3.isFull()){
//                potNode3.getSmallerPot().load(potNode3);
//            }else if(potNode5.isFull()){
//                potNode5.getBiggerPot().load(potNode5);
//            }else if(!potNode3.isEmpty() && !potNode3.isFull()){
//                potNode3.getSmallerPot().load(potNode3);
//            }else{
//                potNode3.load(potNode3.getBiggerPot());
//            }
            count++;
            printPotNodes();
            if(potNode5.getSurplus() == 4 || potNode8.getSurplus() == 4){
                System.out.println("找出结果了");
                break;
            }else if(potNode8.getSurplus() == 8){
                System.out.println("无法找出结果");
                break;
            }
        }
    }

    public static void printPotNodes(){
        System.out.println("第" + count + "次 " + "8品壶：" + potNode8.getSurplus()
                + "L;  5品壶：" + potNode5.getSurplus()
                + "L;  3品壶：" + potNode3.getSurplus() + "L;");
    }

    public static void initPotNodes(){
        potNode8 = new PotNode(8,8, potNode5, potNode3);
        potNode5 = new PotNode(5,0, potNode8, potNode3);
        potNode3 = new PotNode(3,0, potNode8, potNode5);
    }
}
