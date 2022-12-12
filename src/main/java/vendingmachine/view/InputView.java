package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import static vendingmachine.view.InputView.Message.*;

public class InputView {

    public static int readInitMoney() {
        System.out.println(MACHINE_MONEY_REQUEST_MESSAGE);

        String input = Console.readLine();
        InputValidator.validateMoney(input);
        return Integer.parseInt(input);
    }

    public static int readUserMoney() {
        System.out.println();
        System.out.println(CONSUMING_MONEY_REQUEST_MESSAGE);

        String input = Console.readLine();
        InputValidator.validateMoney(input);
        return Integer.parseInt(input);
    }

    static class Message {
        static final String MACHINE_MONEY_REQUEST_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
        static final String CONSUMING_MONEY_REQUEST_MESSAGE = "투입 금액을 입력해 주세요.";
    }

}
