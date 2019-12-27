package Ergodic.Question4;

/**
 * @Description
 * @auther nihao
 * @create 2019-12-27 14:33
 */
public class CheckerboardNode {
    private int[][] checkerBoard = new int[3][3]; //棋盘

    public PieceNode currentNode; //当前所走节点

    private int count = 0;

    public CheckerboardNode(){}

    public CheckerboardNode(int[][] checkerBoard, int count) {
        for(int i = 0; i < checkerBoard.length; i++){
            for(int j = 0; j < checkerBoard[i].length; j++){
                this.checkerBoard[i][j] = checkerBoard[i][j];
            }
        }
        this.count = count;
    }

    /**
     * 访问棋盘点
     * @param x
     * @param y
     */
    public void visit(int x, int y){
        count++;
        checkerBoard[x][y] = count;
        currentNode = new PieceNode(x, y, count);
    }

    /**
     * 查看是否访问过和是否越界
     * @param x
     * @param y
     * @return
     */
    public boolean isVisited(int x, int y){
        if(x >=0 && x < 3 && y >=0 && y < 3){
            return Math.abs(currentNode.getX() - x) + Math.abs(currentNode.getY() - y) == 1 && checkerBoard[x][y] == 0;
        }
        return false;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int[][] getCheckerBoard() {
        return checkerBoard;
    }

    public void setCheckerBoard(int[][] checkerBoard) {
        for(int i = 0; i < checkerBoard.length; i++){
            for(int j = 0; j < checkerBoard[i].length; j++){
                this.checkerBoard[i][j] = checkerBoard[i][j];
            }
        }
    }

    public void printBoard() {
        System.out.println("-------------------");
        for(int i = 0; i < checkerBoard.length; i++){
            System.out.print("\t");
            for(int  j = 0; j < checkerBoard[i].length; j++){
                System.out.print(checkerBoard[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("-------------------");
        System.out.println("");
    }
}