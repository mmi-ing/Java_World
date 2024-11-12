package am;

import java.io.Serializable;

public class DrinkVO implements Serializable {
    String name;
    int Price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public static void main(String[] args) {

    }
}
