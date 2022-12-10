package vendingmachine.controller;

import vendingmachine.model.domain.MachineCoins;
import vendingmachine.model.domain.MachineCoinsMaker;
import vendingmachine.view.InputView;

public class VendingMachineController {
    public static final InputView inputView = new InputView();

    public void run() {
        System.out.println(makeMachineCoins());
    }

    private MachineCoins makeMachineCoins() {
        int holdingAmount = inputView.inputHoldingAmount();
        return new MachineCoins(new MachineCoinsMaker(), holdingAmount);
    }
}
