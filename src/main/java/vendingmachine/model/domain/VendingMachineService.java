package vendingmachine.model.domain;

import java.util.List;
import java.util.Map;
import vendingmachine.controller.DTOConverter;
import vendingmachine.dto.CoinDTO;
import vendingmachine.dto.ItemDTO;

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
