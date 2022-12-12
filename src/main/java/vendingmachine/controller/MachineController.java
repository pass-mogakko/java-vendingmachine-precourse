package vendingmachine.controller;

import vendingmachine.domain.Machine;
import vendingmachine.domain.dto.CoinDto;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.List;

import static vendingmachine.util.ExceptionHandler.*;

public class MachineController {
    private Machine machine;

    public void run() {
        setUp();
        consume();
    }

    private void setUp() {
        int initMoney = handleInputException(InputView::readInitMoney);
        machine = new Machine(initMoney);

        List<CoinDto> coinDtos = machine.createCoinDto();
        OutputView.printInitCoins(coinDtos);
    }

    private void consume() {
        int userMoney = handleInputException(InputView::readUserMoney);
        machine.setUserMoney(userMoney);
    }

}
