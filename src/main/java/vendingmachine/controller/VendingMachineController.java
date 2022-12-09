package vendingmachine.controller;

import java.util.Map;
import vendingmachine.service.VendingMachineService;
import vendingmachine.util.Utils;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    private final VendingMachineService vendingMachineService = new VendingMachineService();

    public void run() {
        requestVendingMachineHasCoins();
    }

    private void requestVendingMachineHasCoins() {
        int vendingMachineHasChange = Utils.requestInput(InputView::requestVendingMachineHasChange, OutputView::printErrorMessage);
        Map<Integer, Integer> vendingMachineHasCoins = vendingMachineService.createRandomCoin(vendingMachineHasChange);
        OutputView.printVendingMachineHasCoins(vendingMachineHasCoins);
    }
}
