package DynamicProgramming.Question1;

class Commodity{
    int num;//购买数量

    int assumeNum;

    int price;//购买单价

    int code;

    public Commodity(){}

    public Commodity(int num, int price, int code) {
        this.num = num;
        this.price = price;
        this.code = code;
    }

    public int getAssumeNum() {
        return assumeNum;
    }

    public void setAssumeNum(int assumeNum) {
        this.assumeNum = assumeNum;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}