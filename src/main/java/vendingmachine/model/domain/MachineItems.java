package vendingmachine.model.domain;

import static vendingmachine.model.constants.ErrorMessage.ITEMS_DUPLICATED_NAMES;
import static vendingmachine.model.constants.ErrorMessage.ITEMS_NOT_FOUND;
import static vendingmachine.model.constants.ErrorMessage.ITEMS_TOTAL_QUANTITY_OUT_OF_BOUNDS;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class MachineItems {
    private final List<Item> items;

    public MachineItems(List<Item> items) {
        this.items = items;
        validateItemsTotalQuantity();
        validateDuplicatedItemName();
    }

    private void validateItemsTotalQuantity() {
        if (sumQuantity() < 1) {
            throw new IllegalArgumentException(ITEMS_TOTAL_QUANTITY_OUT_OF_BOUNDS);
        }
    }

    public int sumQuantity() {
        return items.stream()
                .map(Item::getQuantity)
                .reduce(0, Integer::sum);
    }

    private void validateDuplicatedItemName() {
        int removeDuplicatedSize = new HashSet<>(items).size();
        if (removeDuplicatedSize < items.size()) {
            throw new IllegalArgumentException(ITEMS_DUPLICATED_NAMES);
        }
    }

//    public int findMinimumPrice() {
//        return items.stream()
//                .mapToInt(Item::getPrice)
//                .min()
//                .orElseThrow(NoSuchElementException::new);
//    }

    public int takeOutItem(String itemName) {
        Item item = findByName(itemName);
        item.takeOutOne();
        return item.getPrice();
    }

    private Item findByName(String itemName) {
        return items.stream()
                .filter(item -> Objects.equals(item.getName(), itemName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ITEMS_NOT_FOUND));
    }
}
