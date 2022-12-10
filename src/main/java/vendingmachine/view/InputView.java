package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.view.constants.ErrorMessage;
import vendingmachine.view.constants.InputMessage;

public class InputView {
    public int inputHoldingAmount() {
        System.out.println(InputMessage.INPUT_HOLDING_AMOUNT);
        int holdingAmount = readNumber();
        System.out.println();
        return holdingAmount;
    }

    private int readNumber() {
        int readValue = toInteger(Console.readLine());
        if (readValue < 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_INVALID_VALUE);
        }
        return readValue;
    }

    private int toInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_A_NUMBER);
        }
    }
}
