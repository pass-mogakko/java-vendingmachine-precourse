package vendingmachine.controller;

import vendingmachine.service.VendingMachineService;
import vendingmachine.util.Utils;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    private final VendingMachineService vendingMachineService = new VendingMachineService();

    public void run() {
        int vendingMachineHasChange = Utils.requestInput(InputView::requestVendingMachineHasChange, OutputView::printErrorMessage);
        vendingMachineService.createRandomCoin(vendingMachineHasChange);
    }
}
