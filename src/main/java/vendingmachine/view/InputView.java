package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import vendingmachine.dto.ItemDTO;
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
        System.out.println();
        return InputParser.parseItems(readLine);
    }

    public int inputInsertAmount() {
        System.out.println(InputMessage.INPUT_INSERT_MONEY_AMOUNT);
        int amount = readNumber();
        System.out.println();
        return amount;
    }

    private int readNumber() {
        int readValue = InputParser.parseInteger(Console.readLine());
        InputValidator.validateIntegerToNumber(readValue);
        return readValue;
    }
}
