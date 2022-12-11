package vendingmachine.model.domain;

import java.util.List;
import java.util.Map;
import vendingmachine.controller.DTOConverter;
import vendingmachine.dto.CoinDTO;
import vendingmachine.dto.ItemDTO;

public class VendingMachineService {
    private final VendingMachine vendingMachine = new VendingMachine();

    public void insertCoinsToVendingMachine(int holdingAmount) {
        MachineCoins machineCoins = new MachineCoins(new MachineCoinsMaker(), holdingAmount);
        vendingMachine.insertCoins(machineCoins);
    }

    public void insertItemsToVendingMachine(List<ItemDTO> inputItems) {
        Map<Item, Integer> quantityByItem = DTOConverter.toEntity(inputItems);
        MachineItems machineItems = new MachineItems(quantityByItem);
        vendingMachine.insertItems(machineItems);
    }

    public void insertMoneyToVendingMachine(int amount) {
        vendingMachine.insertMoney(amount);
    }

    public void sellMachineItem(String itemName) {
        vendingMachine.sellItem(itemName);
    }

    public List<CoinDTO> getMachineCoins() {
        return DTOConverter.toDTO(vendingMachine.getMachineCoinsCount());
    }

    public List<CoinDTO> getChangeCoins() {
        Map<Coin, Integer> countByChangeCoin = vendingMachine.giveChanges();
        return DTOConverter.toDTOWithOutZeroCount(countByChangeCoin);
    }

    public int getInsertedAmount() {
        return vendingMachine.getInsertedAmount();
    }

    public boolean isMachineAvailable() {
        return vendingMachine.isAvailable();
    }
}
