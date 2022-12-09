package vendingmachine.model.domain;

import java.util.List;

public class VendingMachine {
    private final MachineCoins machineCoins;

    public VendingMachine(int holdingAmount, List<Item> items) {
        machineCoins = new MachineCoins(new MachineCoinsMaker(), holdingAmount);
    }
}
