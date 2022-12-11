package vendingmachine.view;

import static vendingmachine.view.constants.InputFormat.ITEMS_DELIMITER;
import static vendingmachine.view.constants.InputFormat.ITEM_PROPERTY_DELIMITER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.dto.ItemDTO;
import vendingmachine.view.constants.ErrorMessage;

public class InputParser {
    public static List<ItemDTO> parseItems(String readLine) {
        String[] inputItems = readLine.split(ITEMS_DELIMITER);
        InputValidator.validateItemsFormat(inputItems);
        List<ItemDTO> parsedItems = Arrays.stream(inputItems)
                .map(InputParser::parseItem)
                .collect(Collectors.toList());
        InputValidator.validateDuplicatedItemName(parsedItems);
        return parsedItems;
    }

    public static ItemDTO parseItem(String inputItem) {
        String item = inputItem.substring(1, inputItem.length() - 1);
        String[] properties = item.split(ITEM_PROPERTY_DELIMITER);
        return new ItemDTO(properties[0], parseInteger(properties[1]), parseInteger(properties[2]));
    }

    public static int parseInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER);
        }
    }
}
