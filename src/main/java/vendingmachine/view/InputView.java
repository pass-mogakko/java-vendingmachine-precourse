package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import static vendingmachine.view.InputView.Message.*;

public class InputView {

    public static String readMachineMoney() {
        System.out.println(MACHINE_MONEY_MESSAGE);
        return Console.readLine();
    }

    class Message {
        static final String MACHINE_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

    }

}
