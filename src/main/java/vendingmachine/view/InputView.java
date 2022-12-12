package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import static vendingmachine.view.InputView.Message.*;

public class InputView {

    public static int readMachineMoney() {
        System.out.println(MACHINE_MONEY_REQUEST_MESSAGE);
        String input = Console.readLine();
        InputValidator.validateMachineMoney(input);
        return Integer.parseInt(input);
    }

    static class Message {
        static final String MACHINE_MONEY_REQUEST_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    }

}
