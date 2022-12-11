package vendingmachine.view;

import static vendingmachine.view.constants.InputFormat.ITEMS_DELIMITER;
import static vendingmachine.view.constants.InputFormat.ITEM_PROPERTY_DELIMITER;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.dto.ItemDTO;
import vendingmachine.view.constants.ErrorMessage;
import vendingmachine.view.constants.InputMessage;

public class InputView {
    public static String inputPurchaseItemName() {
        System.out.println(InputMessage.INPUT_PURCHASE_ITEM_NAME);
        String itemName = Console.readLine();
        InputValidator.validateString(itemName);
        System.out.println();
        return itemName;
    }

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
        System.out.println();
        return parseItems(inputItems);
    }

    public int inputInsertAmount() {
        System.out.println(InputMessage.INPUT_INSERT_MONEY_AMOUNT);
        int amount = readNumber();
        System.out.println();
        return amount;
    }

    private List<ItemDTO> parseItems(String[] inputItems) {
        InputValidator.validateItemsFormat(inputItems);
        List<ItemDTO> parsedItems = Arrays.stream(inputItems)
                .map(this::parseItem)
                .collect(Collectors.toList());
        InputValidator.validateDuplicatedItemName(parsedItems);
        return parsedItems;
    }

    private ItemDTO parseItem(String inputItem) {
        String item = inputItem.substring(1, inputItem.length() - 1);
        String[] properties = item.split(ITEM_PROPERTY_DELIMITER);
        return new ItemDTO(properties[0], parseInteger(properties[1]), parseInteger(properties[2]));
    }

    private int readNumber() {
        int readValue = parseInteger(Console.readLine());
        InputValidator.validateIntegerToNumber(readValue);
        return readValue;
    }

    private int parseInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER);
        }
    }
}
