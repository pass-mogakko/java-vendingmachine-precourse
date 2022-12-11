package vendingmachine.model.domain;

import static vendingmachine.model.constants.ErrorMessage.ITEMS_NOT_FOUND;
import static vendingmachine.model.constants.ErrorMessage.ITEM_QUANTITY_OUT_OF_BOUNDS;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import vendingmachine.model.constants.ErrorMessage;

public class MachineItems {
    private final Map<Item, Integer> quantityByItem;

    public MachineItems(Map<Item, Integer> quantityByItem) {
        validateQuantityByItem(quantityByItem);
        this.quantityByItem = quantityByItem;
    }

    private void validateQuantityByItem(Map<Item, Integer> quantityByItem) {
        if (hasInvalidQuantity(quantityByItem)) {
            throw new IllegalArgumentException(ITEM_QUANTITY_OUT_OF_BOUNDS);
        }
    }

    private boolean hasInvalidQuantity(Map<Item, Integer> quantityByItem) {
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

    public boolean isEmpty() {
        return quantityByItem.isEmpty();
    }
}
