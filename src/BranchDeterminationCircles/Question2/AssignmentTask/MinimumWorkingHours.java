package BranchDeterminationCircles.Question2.AssignmentTask;

import java.util.Scanner;

/**
 * @Description
 * @auther nihao
 * @create 2019-12-31 15:17
 */
public class MinimumWorkingHours {
    public static int taskNum;

    public static int machineNum;

    public static int[] task;

    public static int[] machine;

    public static int minTime;

    public static void main(String[] args) {
        loadData();
    }

    public static void loadData() {
        Scanner sc = new Scanner(System.in);
        taskNum = sc.nextInt();
        machineNum = sc.nextInt();
        task = new int[taskNum];
        machine = new int[machineNum];
        //默认最短时间为总任务之和
        for(int i = 0; i < taskNum; i++) {
            task[i] = sc.nextInt();
            minTime+=task[i];
        }
        findMin(0);
        System.out.println("最短时间为：");
        System.out.println(minTime);
    }

    public static void findMin(int index){
        if(index < taskNum){
            //递归所有情形
            for(int k = 0; k < machineNum; k++){
                //只有当加入任务的机器的时间小雨当前最短时间才加入 ---- 剪枝
                if(machine[k] + task[index] < minTime) {
                    machine[k] += task[index];
                    findMin(index + 1);
                    machine[k] -= task[index];
                }
            }
        }else{
            //所有任务布置完，求的当前机器所消耗的最大时间
            int min = 0;
            for(int j = 0; j < machineNum; j++) {
                min = Math.max(min, machine[j]);
            }
            minTime = Math.min(min, minTime);
        }
    }
}