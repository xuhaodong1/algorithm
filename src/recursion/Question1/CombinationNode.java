package recursion.Question1;

/**
 * @Description
 * @auther nihao
 * @create 2019-12-24 15:25
 */
public class CombinationNode{
    private int n;

    private int k;

    @Override
    public boolean equals(Object obj) {
        CombinationNode temp = (CombinationNode)obj;
        return temp.k == this.k && temp.n == this.n;
    }

    /**
     * 使仅比较值，不比较地址
     * @return
     */
    @Override
    public int hashCode() {
        return 0;
    }

    public CombinationNode(int n, int k) {
        this.n = n;
        this.k = k;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }
}