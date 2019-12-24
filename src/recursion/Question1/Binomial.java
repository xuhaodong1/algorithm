package recursion.Question1;

import java.util.*;

/**
 * @Description
 * 完成二项式公式计算
 * @auther nihao
 * @create 2019-12-24 14:50
 */
public class Binomial {
    public static Map<CombinationNode, Integer> resultSMap; //备忘录算法所用存储map

    public static void main(String[] args){
        resultSMap = new HashMap();
        Integer a =  memorandumBinomial(10, 5 );
        System.out.println(a);
    }
    public static int iterationBinomial(int n, int k){
        return 0;
    }

    /**
     * 备忘录算法
     * @param n
     * @param k
     * @return 组合公式 计算结果
     */
    public static int memorandumBinomial(int n, int k){
        if( resultSMap.containsKey(new CombinationNode(n, k)) ){
            return resultSMap.get(new CombinationNode(n, k));
        }
        if(n == k){
            return 1;
        }else if(k == 1){
            return n;
        }else{
            int result = memorandumBinomial(n - 1, k) + memorandumBinomial(n - 1, k - 1);
            resultSMap.put(new CombinationNode(n, k), result);
            return result;
        }
    }

    /**
     * 递归算法
     * @param n
     * @param k
     * @return 组合公式 计算结果
     */
    public static int recursionBinomial(int n, int k){
        if(n == k){
            return 1;
        }else if(k == 1){
            return n;
        }else{
            return recursionBinomial(n - 1, k - 1) + recursionBinomial(n - 1, k);
        }
    }
}