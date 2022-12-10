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
        validateInputAmount(insertAmount);
        insertedAmount += insertAmount;
    }

    private void validateInputAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MONEY_OUT_OF_BOUNDS);
        }
    }

    public Map<Coin, Integer> getMachineCoinsCount() {
        return machineCoins.getCountByCoin();
    }

    public int getInsertedAmount() {
        return insertedAmount;
    }

    public void sellItem(String itemName) {
        int price = machineItems.takeOutItem(itemName);
        insertedAmount -= price;
    }

//    public boolean isAvailable() {
//        if (insertedAmount < machineItems.findMinimumPrice()) {
//            return false;
//        }
//        return machineItems.sumQuantity() != 0;
//    }
}
