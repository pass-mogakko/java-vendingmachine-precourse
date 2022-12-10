package vendingmachine.controller;

import java.util.List;
import vendingmachine.dto.CoinDTO;
import vendingmachine.dto.ItemDTO;
import vendingmachine.model.domain.VendingMachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final VendingMachineService vendingMachineService = new VendingMachineService();

    public void run() {
        insertCoins();
        showMachineCoins();
        insertItems();
        insertMoney();
        purchaseItemUntilAvailable();
    }

    private void insertCoins() {
        int holdingAmount = inputView.inputHoldingAmount();
        vendingMachineService.insertCoinsToVendingMachine(holdingAmount);
    }

    private void showMachineCoins() {
        List<CoinDTO> machineCoins = vendingMachineService.getMachineCoins();
        outputView.printMachineCoins(machineCoins);
    }

    private void insertItems() {
        List<ItemDTO> machineItems = inputView.inputItems();
        vendingMachineService.insertItemsToVendingMachine(machineItems);
    }

    private void insertMoney() {
        int insertAmount = inputView.inputInsertAmount();
        vendingMachineService.insertMoneyToVendingMachine(insertAmount);
    }

    private void purchaseItemUntilAvailable() {
        while (vendingMachineService.isMachineAvailable()) {
            showCurrentAmount();
            String itemName = inputView.inputPurchaseItemName();
            vendingMachineService.sellMachineItem(itemName);
        }
    }

    private void showCurrentAmount() {
        int currentAmount = vendingMachineService.getInsertedAmount();
        outputView.printInsertedAmount(currentAmount);
    }
}
