package vendingmachine.controller;

import vendingmachine.util.Utils;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    public void run() {
        int vendingMachineHasCoin = Utils.requestInput(InputView::requestVendingMachineHasCoin, OutputView::printErrorMessage);
    }
}
