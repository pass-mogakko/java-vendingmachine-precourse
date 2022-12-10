package vendingmachine.model.domain;

import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.dto.ItemDTO;

public class VendingMachine {
    private final MachineCoins machineCoins;
    private final MachineItems machineItems;
    private final int inputAmount = 0;

    public VendingMachine(int holdingAmount, List<ItemDTO> items) {
        machineCoins = new MachineCoins(new MachineCoinsMaker(), holdingAmount);
        machineItems = new MachineItems(convert(items));
    }

    private List<Item> convert(List<ItemDTO> itemDTOs) {
        return itemDTOs.stream()
                .map(itemDTO -> new Item(itemDTO.getName(), itemDTO.getPrice(), itemDTO.getQuantity()))
                .collect(Collectors.toList());
    }
}
