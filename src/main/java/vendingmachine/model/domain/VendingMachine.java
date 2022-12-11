package vendingmachine.model.domain;

import java.util.Map;
import vendingmachine.model.constants.ErrorMessage;

public class VendingMachine {
    private int insertedAmount = 0;
    private MachineCoins machineCoins;
    private MachineItems machineItems;

    public void insertCoins(MachineCoins coins) {
        this.machineCoins = coins;
    }

    public void insertItems(MachineItems machineItems) {
        this.machineItems = machineItems;
    }

    public void insertMoney(int insertAmount) {
        validateInsertAmount(insertAmount);
        insertedAmount += insertAmount;
    }

    private void validateInsertAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MONEY_OUT_OF_BOUNDS);
        }
    }

    public Map<Coin, Integer> getMachineCoinsQuantity() {
        return machineCoins.getQuantityByCoin();
    }

    public int getInsertedAmount() {
        return insertedAmount;
    }

    public boolean isAvailable() {
        if (insertedAmount < machineItems.findMinimumPrice()) {
            return false;
        }
        return machineItems.sumQuantity() != 0;
    }

    public void sellItem(String itemName) {
        int price = machineItems.takeOutItem(itemName);
        insertedAmount -= price;
    }

    public Map<Coin, Integer> giveChangeCoins() {
        return machineCoins.giveChangeCoins(insertedAmount);
    }
}
