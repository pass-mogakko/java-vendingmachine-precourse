package vendingmachine.model.domain;

import static vendingmachine.model.constants.ErrorMessage.ITEM_PRICE_INVALID_MULTIPLE;
import static vendingmachine.model.constants.ErrorMessage.ITEM_PRICE_OUT_OF_BOUNDS;
import static vendingmachine.model.domain.Coin.COIN_10;
import static vendingmachine.model.domain.Coin.COIN_100;

import java.util.Objects;

public class Item {
    private final String name;
    private final int price;

    public Item(String name, int price) {
        validatePrice(price);
        this.name = name;
        this.price = price;
    }

    private void validatePrice(int price) {
        if ((price % COIN_10.getAmount()) != 0) {
            throw new IllegalArgumentException(ITEM_PRICE_INVALID_MULTIPLE);
        }
        if (price < COIN_100.getAmount()) {
            throw new IllegalArgumentException(ITEM_PRICE_OUT_OF_BOUNDS);
        }
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
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
