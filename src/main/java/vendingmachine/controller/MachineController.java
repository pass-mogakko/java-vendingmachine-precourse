package vendingmachine.controller;

import vendingmachine.view.InputView;

import static vendingmachine.util.ExceptionHandler.*;

public class MachineController {
    public void run() {
        createCoins();
    }

    private void createCoins() {
        String machineMoney = handleException(InputView::readMachineMoney);
    }
}
