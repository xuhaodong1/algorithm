package Ergodic.Question4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description
 * @auther nihao
 * @create 2019-12-27 14:24
 */
public class SPFPC {
    public static Queue<CheckerboardNode> inHand = new LinkedList<>(); //棋盘队列
    public static int count = 0; //计数成功情况
    public static void main(String[] args){
        findAllSPFPC();
    }

    public static void findAllSPFPC(){
        initAllFirstStep();
        while(!inHand.isEmpty()){
            CheckerboardNode currentBoard = inHand.poll();
            PieceNode currentNode = currentBoard.currentNode;
            List<PieceNode> nextSteps = getAllNextStep(currentNode);
            for(PieceNode node : nextSteps){
                if(currentBoard.isVisited(node.getX(), node.getY())){
                    CheckerboardNode temp = new CheckerboardNode(currentBoard.getCheckerBoard(), currentBoard.getCount());
                    temp.visit(node.getX(), node.getY());
                    inHand.offer(temp);
                    if(temp.getCount() == 9){
                        count++;
                        temp.printBoard();
                    }
                }
            }
        }
        System.out.println("9宫格总共有" + count + "个走法");
    }

    /**
     * 求出下一步所走的所有情况
     * @param currentNode
     * @return
     */
    public static List<PieceNode> getAllNextStep(PieceNode currentNode){
        List<PieceNode> nextStep = new ArrayList<>();
        nextStep.add(new PieceNode(currentNode.getX() + 1, currentNode.getY()));
        nextStep.add(new PieceNode(currentNode.getX() - 1, currentNode.getY()));
        nextStep.add(new PieceNode(currentNode.getX(), currentNode.getY() + 1));
        nextStep.add(new PieceNode(currentNode.getX(), currentNode.getY() - 1));
        return nextStep;
    }

    /*
    初始化所有的第一步
     */
    public static void initAllFirstStep(){
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                CheckerboardNode first = new CheckerboardNode();
                first.visit(x, y);
                inHand.offer(first);
            }
        }
    }
}