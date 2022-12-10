package vendingmachine.model.domain;

import java.util.HashSet;
import java.util.List;
import vendingmachine.model.constants.ErrorMessage;

public class MachineItems {
    private final List<Item> items;

    public MachineItems(List<Item> items) {
        validateItemsTotalQuantity(items);
        validateDuplicatedItemName(items);
        this.items = items;
    }

    private void validateItemsTotalQuantity(List<Item> items) {
        if (sumQuantity(items) == 0) {
            throw new IllegalArgumentException(ErrorMessage.ITEMS_TOTAL_QUANTITY_OUT_OF_BOUNDS);
        }
    }

    private int sumQuantity(List<Item> items) {
        return items.stream()
                .map(item -> item.getQuantity())
                .reduce(0, Integer::sum);
    }

    private void validateDuplicatedItemName(List<Item> items) {
        int removeDuplicatedSize = new HashSet<>(items).size();
        if (removeDuplicatedSize < items.size()) {
            throw new IllegalArgumentException(ErrorMessage.ITEMS_DUPLICATED_NAMES);
        }
    }
}
