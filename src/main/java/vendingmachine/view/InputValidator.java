package vendingmachine.view;

import vendingmachine.constant.Setting;

import static vendingmachine.constant.ErrorMessage.*;

class InputValidator {

    static void validateMoney(String input) {
        try {
            int number = Integer.parseInt(input);
            checkNumberRange(number);
            checkNumberUnit(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_MACHINE_MONEY);
        }
    }


    private static void checkNumberRange(int number) {
        if (number < Setting.MINIMAL_MACHINE_MONEY) {
            throw new IllegalArgumentException(INVALID_MACHINE_MONEY);
        }
    }

    private static void checkNumberUnit(int number) {
        if (number % Setting.MINIMAL_MONEY_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_MONEY_UNIT);
        }
    }

}
