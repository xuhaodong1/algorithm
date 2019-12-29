package DynamicProgramming.Question1;

import java.util.ArrayList;
import java.util.List;

public class Discount {
    public List<Commodity> discount = new ArrayList<>();

    public int totalPrice;

    public Discount(){}

    public Discount(List<Commodity> discount, int totalPrice) {
        this.discount = discount;
        this.totalPrice = totalPrice;
    }

    public List<Commodity> getDiscount() {
        return discount;
    }

    public void setDiscount(List<Commodity> discount) {
        this.discount = discount;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
