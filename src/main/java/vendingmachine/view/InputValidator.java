package vendingmachine.view;

import static vendingmachine.util.ErrorMessage.*;

class InputValidator {

    static void validateMachineMoney(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_MACHINE_MONEY);
        }
    }

}
