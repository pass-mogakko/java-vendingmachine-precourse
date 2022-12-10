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
        initializeMachineCoins();
        showMachineCoins();
        initializeMachineItems();
        insertMoney();
    }

    private void initializeMachineCoins() {
        int holdingAmount = inputView.inputHoldingAmount();
        vendingMachineService.insertCoinsToVendingMachine(holdingAmount);
    }

    private void showMachineCoins() {
        List<CoinDTO> machineCoins = vendingMachineService.getMachineCoins();
        outputView.printMachineCoins(machineCoins);
    }

    private void initializeMachineItems() {
        List<ItemDTO> machineItems = inputView.inputItems();
        vendingMachineService.insertItemsToVendingMachine(machineItems);
    }

    private void insertMoney() {
        int insertMoneyAMount = inputView.inputInsertMoneyAmount();
        vendingMachineService.insertMoneyToVendingMachine(insertMoneyAMount);
    }
}
