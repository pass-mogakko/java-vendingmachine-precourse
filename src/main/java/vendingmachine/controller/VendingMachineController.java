package vendingmachine.controller;

import java.util.Map;
import vendingmachine.service.VendingMachineService;
import vendingmachine.util.Utils;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    private final VendingMachineService vendingMachineService = new VendingMachineService();

    public void run() {
        requestVendingMachineHasChange();
        Utils.exceptionHandlingRepeatSelf(this::requestVendingMachineHasProducts, OutputView::printErrorMessage);
        requestInsertMoney();
    }

    private void requestVendingMachineHasChange() {
        int vendingMachineHasChange = Utils.requestInput(InputView::requestVendingMachineHasChanges, OutputView::printErrorMessage);
        Map<Integer, Integer> vendingMachineHasCoins = vendingMachineService.createRandomCoin(vendingMachineHasChange);
        OutputView.printVendingMachineHasCoins(vendingMachineHasCoins);
    }

    private void requestVendingMachineHasProducts() {
        String products = InputView.requestVendingMachineHasProducts();
        vendingMachineService.insertProducts(products);
    }

    private void requestInsertMoney() {
        int insertMoney = Utils.requestInput(InputView::requestInsertMoney, OutputView::printErrorMessage);
    }
}
