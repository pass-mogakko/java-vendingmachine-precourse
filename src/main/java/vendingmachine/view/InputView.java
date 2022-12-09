package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constant.Constant;
import vendingmachine.constant.ErrorMessage;
import vendingmachine.constant.Message;
import vendingmachine.util.Utils;

public class InputView {

    public static int requestVendingMachineHasChanges() {
        System.out.println();
        System.out.println(Message.REQUEST_VENDING_MACHINE_HAS_CHANGES);
        String input = Console.readLine();
        validateMoney(input);
        return Integer.parseInt(input);
    }

    static void validateMoney(String input) {
        if (!Utils.isNumber(input)) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_MUST_BE_NUMBER);
        }
        int vendingMachineHasCoin = Integer.parseInt(input);
        if (vendingMachineHasCoin <= 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_MUST_BE_GREATER_THAN_ZERO);
        }
        if (vendingMachineHasCoin % Constant.TEN_WON_VALUE != 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_MUST_BE_DIVISIBLE_TEN_WON);
        }
    }

    public static String requestVendingMachineHasProducts() {
        System.out.println();
        System.out.println(Message.REQUEST_VENDING_MACHINE_HAS_PRODUCTS);
        return Console.readLine();
    }

    public static int requestInsertMoney() {
        System.out.println();
        System.out.println(Message.REQUEST_INSERT_MONEY);
        String input = Console.readLine();
        validateMoney(input);
        return Integer.parseInt(input);
    }

}
