package vendingmachine.view;

import static vendingmachine.view.constants.InputFormat.ITEMS_DELIMITER;
import static vendingmachine.view.constants.InputFormat.ITEM_PATTERN;
import static vendingmachine.view.constants.InputFormat.ITEM_PROPERTY_DELIMITER;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.dto.ItemDTO;
import vendingmachine.view.constants.ErrorMessage;
import vendingmachine.view.constants.InputMessage;

public class InputView {
    public int inputHoldingAmount() {
        System.out.println(InputMessage.INPUT_HOLDING_AMOUNT);
        int holdingAmount = readNumber();
        System.out.println();
        return holdingAmount;
    }

    public List<ItemDTO> inputItems() {
        System.out.println(InputMessage.INPUT_ITEMS);
        String readLine = Console.readLine();
        String[] inputItems = readLine.split(ITEMS_DELIMITER);
        validateItemsFormat(inputItems);
        System.out.println();
        return parseItems(inputItems);
    }

    private void validateItemsFormat(String[] inputItems) {
        if (inputItems.length == 1 && inputItems[0].isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_ITEM);
        }
        if (!isCorrectFormat(inputItems)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ITEM_FORMAT);
        }
    }

    private List<ItemDTO> parseItems(String[] inputItems) {
        return Arrays.stream(inputItems)
                .map(this::parseItem)
                .collect(Collectors.toList());
    }

    private ItemDTO parseItem(String inputItem) {
        String item = inputItem.substring(1, inputItem.length() - 1);
        String[] properties = item.split(ITEM_PROPERTY_DELIMITER);
        return new ItemDTO(properties[0], toInteger(properties[1]), toInteger(properties[2]));
    }

    private boolean isCorrectFormat(String[] inputItems) {
        return Arrays.stream(inputItems)
                .allMatch(inputItem -> ITEM_PATTERN.matcher(inputItem).matches());
    }

    public int inputInsertAmount() {
        System.out.println(InputMessage.INPUT_INSERT_MONEY_AMOUNT);
        int amount = readNumber();
        System.out.println();
        return amount;
    }

    public String inputPurchaseItemName() {
        System.out.println(InputMessage.INPUT_PURCHASE_ITEM_NAME);
        String itemName = Console.readLine();
        validateString(itemName);
        System.out.println();
        return itemName;
    }

    private void validateString(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_OR_EMPTY_STRING);
        }
    }

    private int readNumber() {
        int readValue = toInteger(Console.readLine());
        validateIntegerToNumber(readValue);
        return readValue;
    }

    private void validateIntegerToNumber(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VALUE);
        }
    }

    private int toInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER);
        }
    }
}
