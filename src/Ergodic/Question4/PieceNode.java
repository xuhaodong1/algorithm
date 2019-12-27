package Ergodic.Question4;

/**
 * @Description
 * @auther nihao
 * @create 2019-12-27 15:08
 */
public class PieceNode {
    private int x;

    private int y;

    private int step;

    public PieceNode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PieceNode(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}