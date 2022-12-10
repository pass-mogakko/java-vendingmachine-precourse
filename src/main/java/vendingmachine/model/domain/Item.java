package vendingmachine.model.domain;

import static vendingmachine.model.constants.ErrorMessage.ITEM_PRICE_INVALID_MULTIPLE;
import static vendingmachine.model.constants.ErrorMessage.ITEM_PRICE_OUT_OF_BOUNDS;
import static vendingmachine.model.constants.ErrorMessage.ITEM_QUANTITY_OUT_OF_BOUNDS;
import static vendingmachine.model.constants.ErrorMessage.PURCHASE_SOLD_OUT;
import static vendingmachine.model.domain.Coin.COIN_10;
import static vendingmachine.model.domain.Coin.COIN_100;

import java.util.Objects;

public class Item {
    private final String name;
    private final int price;
    private int quantity;

    public Item(String name, int price, int quantity) {
        validatePrice(price);
        validateQuantity(quantity);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    private void validatePrice(int price) {
        if ((price % COIN_10.getAmount()) != 0) {
            throw new IllegalArgumentException(ITEM_PRICE_INVALID_MULTIPLE);
        }
        if (price < COIN_100.getAmount()) {
            throw new IllegalArgumentException(ITEM_PRICE_OUT_OF_BOUNDS);
        }
    }

    private void validateQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException(ITEM_QUANTITY_OUT_OF_BOUNDS);
        }
    }

    public void takeOutOne() {
        if (quantity == 0) {
            throw new IllegalArgumentException(PURCHASE_SOLD_OUT);
        }
        quantity--;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
