package vendingmachine.controller;

import java.util.List;
import vendingmachine.dto.CoinDTO;
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
    }

    private void initializeMachineCoins() {
        int holdingAmount = inputView.inputHoldingAmount();
        vendingMachineService.insertCoinsByHoldingAmount(holdingAmount);
    }

    private void showMachineCoins() {
        List<CoinDTO> machineCoins = vendingMachineService.getMachineCoins();
        outputView.printMachineCoins(machineCoins);
    }
}
