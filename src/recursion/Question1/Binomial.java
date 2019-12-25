package recursion.Question1;

import java.util.*;

/**
 * @Description
 * 完成二项式公式计算
 * @auther nihao
 * @create 2019-12-24 14:50
 */
public class Binomial {
    public static Map<CombinationNode, Integer> resultSMap; // 备忘录算法所用存储map

    public static Queue<CombinationNode> queue; // 迭代法所用全局栈

    public static void main(String[] args){
        resultSMap = new HashMap();
        queue = new LinkedList<>();
        Integer a =  iterationBinomial(10, 5 );
        System.out.println(a);
    }

    /**
     * 迭代算法
     * @param n
     * @param k
     * @return 组合公式 计算结果
     */
    public static int iterationBinomial(int n, int k){
        int sum = 0;
        queue.offer(new CombinationNode(n, k));
        while(!queue.isEmpty()){
            CombinationNode top = queue.element();
            if(canDealWith(top)){
                sum += top.getResult();
                queue.poll();
            }else{
                queue.offer(new CombinationNode(top.getN() - 1, top.getK() - 1));
                queue.offer(new CombinationNode(top.getN() - 1, top.getK()));
                queue.poll();
            }
        }
        return sum;
    }

    /**
     * 检查节点（combinationNode）是否可直接得出结果并存储结果
     * @param combinationNode
     * @return
     */
    public static boolean canDealWith(CombinationNode combinationNode){
        if(combinationNode.getN() == combinationNode.getK()){
            combinationNode.setResult(1);
            return true;
        }else if(combinationNode.getK() == 1){
            combinationNode.setResult(combinationNode.getN());
            return true;
        }
        return combinationNode.getResult() != 0;
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