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
//思路：
//倒水的壶不能同时倒两次 push
//接水的壶不能同时接两次 pull
//其中空闲的壶第二次一定会利用
public class WaterLoading {

    public static PotNode potNode8; //容量较大的水壶
    public static PotNode potNode5; //容量处于中间的水壶
    public static PotNode potNode3; //容量较小的水壶
    public static int count = 0;

    public static PotNode pull; //上次接水的水壶
    public static PotNode push; //上次倒水的水壶
    public static PotNode nothing; //上次什么都没做的水壶

    public static void main(String[] args) {
        initPotNodes();
        while(true){
            //第一次时
            if(pull == null && push == null && nothing == null){
                potNode3.load(potNode8);
                pull = potNode3;
                push = potNode8;
                nothing = potNode5;
            }else if(pull.isFull()){ //接水的满了，赶紧转移
                nothing.load(pull);
                PotNode temp1 = nothing;
                PotNode temp2 = push;
                PotNode temp3 = pull;
                nothing = temp2;
                push = temp3;
                pull = temp1;
            }else if(push.isEmpty()){ //倒水的空了，赶紧填上
                push.load(nothing);
                PotNode temp1 = nothing;
                PotNode temp2 = push;
                PotNode temp3 = pull;
                nothing = temp3;
                push = temp1;
                pull = temp2;
            }
            count++;
            printPotNodes();
            if(potNode5.getSurplus() == 6 || potNode8.getSurplus() == 6){
                System.out.println("找出结果了");
                break;
            }else if(potNode8.getSurplus() == 12){
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
        potNode8 = new PotNode(12,12);
        potNode5 = new PotNode(8,0);
        potNode3 = new PotNode(5,0);
    }
}
