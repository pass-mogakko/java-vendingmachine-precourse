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
        insertMoney();
        useVendingMachine();
        takeChange();
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

    private void insertMoney() {
        int money = Utils.requestInput(InputView::requestInsertMoney, OutputView::printErrorMessage);
        vendingMachineService.insertMoney(money);
    }

    private void useVendingMachine() {
        while (vendingMachineService.isPossibleToBuy()) {
            Utils.exceptionHandlingRepeatSelf(this::buyProduct, OutputView::printErrorMessage);
        }
    }

    private void buyProduct() {
        int remainingMoney = vendingMachineService.findRemainingMoney();
        OutputView.printRemainingMoney(remainingMoney);
        String productName = InputView.requestBuyProduct();
        vendingMachineService.buyProduct(productName);
    }

    private void takeChange() {
        int remainingMoney = vendingMachineService.findRemainingMoney();
        OutputView.printRemainingMoney(remainingMoney);
        Map<Integer, Integer> changeAndChangeCount = vendingMachineService.takeChange();
        OutputView.printChange(changeAndChangeCount);
    }
}
