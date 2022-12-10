package vendingmachine.model.domain;

import java.util.Map;
import vendingmachine.model.constants.ErrorMessage;

public class VendingMachine {
    private final int inputMoney = 0;
    private MachineCoins machineCoins;
    private MachineItems machineItems;

    public void insertCoins(MachineCoins coins) {
        this.machineCoins = coins;
    }

    public void insertItems(MachineItems machineItems) {
        this.machineItems = machineItems;
    }

    public void insertMoney(int inputMoney) {
        validateInputMoney(inputMoney);
        inputMoney += inputMoney;
    }

    public Map<Coin, Integer> getMachineCoinsCount() {
        return machineCoins.getCountByCoin();
    }

    private void validateInputMoney(int inputMoney) {
        if (inputMoney < 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MONEY_OUT_OF_BOUNDS);
        }
    }
}
