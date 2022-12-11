package vendingmachine.view;

import static vendingmachine.view.constants.InputFormat.ITEM_PATTERN;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.dto.ItemDTO;
import vendingmachine.view.constants.ErrorMessage;

public class InputValidator {
    public static void validateString(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_OR_EMPTY_STRING);
        }
    }

    public static void validateIntegerToNumber(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VALUE);
        }
    }

    public static void validateItemsFormat(String[] inputItems) {
        if (inputItems.length == 1 && inputItems[0].isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_ITEM);
        }
        if (!isCorrectFormat(inputItems)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ITEM_FORMAT);
        }
    }

    private static boolean isCorrectFormat(String[] inputItems) {
        return Arrays.stream(inputItems)
                .allMatch(inputItem -> ITEM_PATTERN.matcher(inputItem).matches());
    }

    public static void validateDuplicatedItemName(List<ItemDTO> items) {
        if (hasDuplicatedItemName(items)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_ITEM_NAME);
        }
    }

    private static boolean hasDuplicatedItemName(List<ItemDTO> items) {
        int removeDuplicatedSize = items.stream()
                .map(ItemDTO::getName)
                .collect(Collectors.toSet())
                .size();
        return removeDuplicatedSize != items.size();
    }
}
