package vendingmachine.model.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import vendingmachine.model.constants.ErrorMessage;

public class VendingMachine {
    private int insertedAmount = 0;
    private MachineCoins machineCoins = new MachineCoins(new MachineCoinsMaker(), 0);
    private MachineItems machineItems = new MachineItems(new HashMap<>(Collections.emptyMap()));

    public void setCoins(MachineCoins coins) {
        this.machineCoins = coins;
    }

    public void setItems(MachineItems machineItems) {
        validateItems(machineItems);
        this.machineItems = machineItems;
    }

    private void validateItems(MachineItems machineItems) {
        if (machineItems.sumQuantity() == 0) {
            throw new IllegalArgumentException(ErrorMessage.ITEMS_TOTAL_QUANTITY_OUT_OF_BOUNDS);
        }
    }

    public void insertMoney(int insertAmount) {
        validateInsertAmount(insertAmount);
        insertedAmount += insertAmount;
    }

    private void validateInsertAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INSERT_AMOUNT_OUT_OF_BOUNDS);
        }
        if ((amount % Coin.getMinimumAmount()) != 0) {
            throw new IllegalArgumentException(ErrorMessage.INSERT_AMOUNT_INVALID_MULTIPLE);
        }
        if (amount < machineItems.findMinimumPrice()) {
            throw new IllegalArgumentException(ErrorMessage.INSERT_AMOUNT_INSUFFICIENT);
        }
    }

    public Map<Coin, Integer> getMachineCoinsQuantity() {
        return machineCoins.getQuantityByCoin();
    }

    public int getInsertedAmount() {
        return insertedAmount;
    }

    public boolean isAvailable() {
        if (machineItems.isEmpty()) {
            return false;
        }
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
