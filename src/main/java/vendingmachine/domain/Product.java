package vendingmachine.domain;

import java.util.Objects;

public class Product {

    private String name;
    private int price;

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    boolean nameEquals(String inputName) {
        return Objects.equals(name, inputName);
    }

    int getPrice() {
        return price;
    }

}
