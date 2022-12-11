package vendingmachine.model.domain;

import static vendingmachine.model.constants.ErrorMessage.ITEMS_NOT_FOUND;
import static vendingmachine.model.constants.ErrorMessage.ITEMS_TOTAL_QUANTITY_OUT_OF_BOUNDS;
import static vendingmachine.model.constants.ErrorMessage.ITEM_QUANTITY_OUT_OF_BOUNDS;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import vendingmachine.model.constants.ErrorMessage;

public class MachineItems {
    private final Map<Item, Integer> quantityByItem;

    public MachineItems(Map<Item, Integer> quantityByItem) {
        this.quantityByItem = quantityByItem;
        validateItemsTotalQuantity();
    }

    private void validateItemsTotalQuantity() {
        if (hasInvalidQuantity()) {
            throw new IllegalArgumentException(ITEM_QUANTITY_OUT_OF_BOUNDS);
        }
        if (sumQuantity() < 1) {
            throw new IllegalArgumentException(ITEMS_TOTAL_QUANTITY_OUT_OF_BOUNDS);
        }
    }

    private boolean hasInvalidQuantity() {
        return quantityByItem.values()
                .stream()
                .anyMatch(quantity -> quantity < 0);
    }

    public int sumQuantity() {
        return quantityByItem.values()
                .stream()
                .reduce(0, Integer::sum);
    }

    public int takeOutItem(String itemName) {
        Item item = findByName(itemName);
        int quantity = quantityByItem.get(item);
        validateCurrentQuantity(quantity);
        quantityByItem.put(item, quantity - 1);
        return item.getPrice();
    }

    private void validateCurrentQuantity(int quantity) {
        if (quantity == 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_SOLD_OUT);
        }
    }

    private Item findByName(String itemName) {
        return quantityByItem.keySet()
                .stream()
                .filter(item -> Objects.equals(item.getName(), itemName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ITEMS_NOT_FOUND));
    }

    public int findMinimumPrice() {
        return quantityByItem.keySet()
                .stream()
                .mapToInt(Item::getPrice)
                .min()
                .orElseThrow(NoSuchElementException::new);
    }
}
