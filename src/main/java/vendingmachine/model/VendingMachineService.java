package vendingmachine.model;

import java.util.List;
import java.util.Map;
import vendingmachine.dto.CoinDTO;
import vendingmachine.dto.ItemDTO;
import vendingmachine.model.domain.Coin;
import vendingmachine.model.domain.Item;
import vendingmachine.model.domain.MachineCoins;
import vendingmachine.model.domain.MachineCoinsMaker;
import vendingmachine.model.domain.MachineItems;
import vendingmachine.model.domain.VendingMachine;

public class VendingMachineService {
    private final VendingMachine vendingMachine = new VendingMachine();

    public void setCoinsToVendingMachine(int holdingAmount) {
        MachineCoins machineCoins = new MachineCoins(new MachineCoinsMaker(), holdingAmount);
        vendingMachine.setCoins(machineCoins);
    }

    public void setItemsToVendingMachine(List<ItemDTO> inputItems) {
        Map<Item, Integer> quantityByItem = DTOConverter.toEntity(inputItems);
        MachineItems machineItems = new MachineItems(quantityByItem);
        vendingMachine.setItems(machineItems);
    }

    public void insertMoneyToVendingMachine(int amount) {
        vendingMachine.insertMoney(amount);
    }

    public void sellMachineItem(String itemName) {
        vendingMachine.sellItem(itemName);
    }

    public List<CoinDTO> getMachineCoins() {
        return DTOConverter.toDTO(vendingMachine.getMachineCoinsQuantity());
    }

    public List<CoinDTO> getChangeCoins() {
        Map<Coin, Integer> quantityByChangeCoin = vendingMachine.giveChangeCoins();
        return DTOConverter.toDTOWithOutZeroValue(quantityByChangeCoin);
    }

    public int getInsertedAmount() {
        return vendingMachine.getInsertedAmount();
    }

    public boolean isMachineAvailable() {
        return vendingMachine.isAvailable();
    }
}
