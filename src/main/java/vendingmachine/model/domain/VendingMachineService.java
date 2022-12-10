package vendingmachine.model.domain;

import java.util.List;
import vendingmachine.controller.DTOConverter;
import vendingmachine.dto.CoinDTO;

public class VendingMachineService {
    private final VendingMachine vendingMachine = new VendingMachine();

    public void insertCoinsByHoldingAmount(int holdingAmount) {
        MachineCoins machineCoins = new MachineCoins(new MachineCoinsMaker(), holdingAmount);
        vendingMachine.insertCoins(machineCoins);
    }

    public List<CoinDTO> getMachineCoins() {
        return DTOConverter.toDTO(vendingMachine.getMachineCoinsCount());
    }
}
