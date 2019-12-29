package DynamicProgramming.Question2;

/**
 * @Description
 * @auther nihao
 * @create 2019-12-29 20:45
 */
public class Flight {
    int start;

    int end;

    int amount;

    public Flight(){}

    public Flight(int start, int end, int amount) {
        this.start = start;
        this.end = end;
        this.amount = amount;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}