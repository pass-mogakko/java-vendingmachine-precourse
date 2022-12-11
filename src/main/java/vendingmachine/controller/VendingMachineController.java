package vendingmachine.controller;

import java.util.List;
import vendingmachine.controller.util.ExceptionHandlingUtils;
import vendingmachine.dto.CoinDTO;
import vendingmachine.dto.ItemDTO;
import vendingmachine.model.VendingMachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final VendingMachineService vendingMachineService = new VendingMachineService();

    public void run() {
        initializeVendingMachine();
        repeatPurchasingItems();
        getChangeCoins();
    }

    private void initializeVendingMachine() {
        ExceptionHandlingUtils.retryForIllegalArgument(this::insertCoins, outputView::printErrorMessage);
        showMachineCoins();
        ExceptionHandlingUtils.retryForIllegalArgument(this::insertItems, outputView::printErrorMessage);
        ExceptionHandlingUtils.retryForIllegalArgument(this::insertMoney, outputView::printErrorMessage);
    }

    private void insertCoins() {
        int holdingAmount = inputView.inputHoldingAmount();
        vendingMachineService.setCoinsToVendingMachine(holdingAmount);
    }

    private void showMachineCoins() {
        List<CoinDTO> machineCoins = vendingMachineService.getMachineCoins();
        outputView.printMachineCoins(machineCoins);
    }

    private void insertItems() {
        List<ItemDTO> machineItems = inputView.inputItems();
        vendingMachineService.setItemsToVendingMachine(machineItems);
    }

    private void insertMoney() {
        int insertAmount = inputView.inputInsertAmount();
        vendingMachineService.insertMoneyToVendingMachine(insertAmount);
    }

    private void repeatPurchasingItems() {
        while (vendingMachineService.isMachineAvailable()) {
            showCurrentAmount();
            ExceptionHandlingUtils.retryForIllegalArgument(this::purchaseItem, outputView::printErrorMessage);
        }
    }

    private void showCurrentAmount() {
        int currentAmount = vendingMachineService.getInsertedAmount();
        outputView.printInsertedAmount(currentAmount);
    }

    private void purchaseItem() {
        String itemName = InputView.inputPurchaseItemName();
        vendingMachineService.sellMachineItem(itemName);
    }

    private void getChangeCoins() {
        showCurrentAmount();
        showChangeCoins();
    }

    private void showChangeCoins() {
        List<CoinDTO> changeCoins = vendingMachineService.getChangeCoins();
        outputView.printChangeCoins(changeCoins);
    }
}
