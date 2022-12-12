package vendingmachine.controller;

import vendingmachine.domain.Coins;
import vendingmachine.domain.Machine;
import vendingmachine.domain.dto.CoinDto;
import vendingmachine.domain.dto.DtoBuilder;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.List;

import static vendingmachine.util.ExceptionHandler.*;

public class MachineController {
    private Machine machine;

    public void run() {
        setUp();

    }

    private void setUp() {
        int machineMoney = handleInputException(InputView::readMachineMoney);
        machine = new Machine(machineMoney);

        List<CoinDto> coinDtos = machine.createCoinDto();
        OutputView.printMachineMoney(coinDtos);
    }

}
