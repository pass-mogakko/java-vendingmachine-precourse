package vendingmachine.model.domain;

import static vendingmachine.model.domain.Coin.COIN_10;
import static vendingmachine.model.domain.Coin.COIN_100;

import java.util.Objects;
import vendingmachine.model.constants.ErrorMessage;

public class Item {
    private final String name;
    private final int price;
    private final int quantity;

    public Item(String name, int price, int quantity) {
        validatePrice(price);
        validateQuantity(quantity);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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

    private void validatePrice(int price) {
        if ((price % COIN_10.getAmount()) != 0) {
            throw new IllegalArgumentException(ErrorMessage.ITEM_PRICE_INVALID_MULTIPLE);
        }
        if (price < COIN_100.getAmount()) {
            throw new IllegalArgumentException(ErrorMessage.ITEM_PRICE_OUT_OF_BOUNDS);
        }
    }

    private void validateQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException(ErrorMessage.ITEM_QUANTITY_OUT_OF_BOUNDS);
        }
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
