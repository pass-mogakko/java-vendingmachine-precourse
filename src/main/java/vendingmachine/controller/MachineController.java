package vendingmachine.controller;

import vendingmachine.domain.Machine;
import vendingmachine.domain.Coins;
import vendingmachine.view.InputView;

import static vendingmachine.util.ExceptionHandler.*;

public class MachineController {
    private Machine machine;
    public void run() {
        setUp();
    }

    private void setUp() {
        int machineMoney = handleInputException(InputView::readMachineMoney);
        machine = new Machine(machineMoney);
    }

}
