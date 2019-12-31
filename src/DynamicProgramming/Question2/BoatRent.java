package DynamicProgramming.Question2;

import Recursion.Question1.Binomial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @auther nihao
 * @create 2019-12-29 20:05
 */
public class BoatRent {

    public static int siteNum;

    public static int[][] flightList;

    public static int[] shortestCost;

    public static void main(String[] args){
        initData();
        computedValue();
    }

    /**
     * 计算金额
     */
    public static void computedValue(){
        int index;
        for( index = 1; index < siteNum; index++){
            int minCost = flightList[0][index]; //默认从0到index为最少花费
            for(int i = 1; i < index; i++){
                if( shortestCost[i] + flightList[i][index] < minCost){
                    minCost = shortestCost[i] + flightList[i][index];
                }
            }
            shortestCost[index] = minCost;
        }
        System.out.println("最少金额为：");
        System.out.println(shortestCost[siteNum - 1]);
        System.out.println("-------------");
    }

    /**
     * 初始化数据
     */
    public static void initData(){
        Scanner input = new Scanner(System.in);
        siteNum = input.nextInt();
        flightList = new int[siteNum][siteNum];
        shortestCost = new int[siteNum];
        for(int i = 0; i < Binomial.recursionBinomial(siteNum, 2); i++){
            int start = input.nextInt();
            int end = input.nextInt();
            int cost = input.nextInt();
            flightList[start - 1][end - 1] = cost;
        }
    }
}