package vendingmachine.model.domain;

import vendingmachine.model.constants.ErrorMessage;

public class VendingMachine {
    private final MachineCoins machineCoins;
    private final MachineItems machineItems;
    private final int inputMoney = 0;

    public VendingMachine(MachineCoins machineCoins, MachineItems machineItems) {
        this.machineCoins = machineCoins;
        this.machineItems = machineItems;
    }

    public void insertMoney(int inputMoney) {
        validateInputMoney(inputMoney);
        inputMoney += inputMoney;
    }

    private void validateInputMoney(int inputMoney) {
        if (inputMoney < 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MONEY_OUT_OF_BOUNDS);
        }
    }
}
