package vendingmachine.view;

import java.util.List;
import vendingmachine.dto.CoinDTO;
import vendingmachine.view.constants.OutputFormat;
import vendingmachine.view.constants.OutputMessage;

public class OutputView {
    public void printMachineCoins(List<CoinDTO> machineCoins) {
        System.out.println(OutputMessage.MACHINE_COINS);
        machineCoins.forEach(coin -> System.out.printf(OutputFormat.MACHINE_COIN, coin.getAmount(), coin.getCount()));
        System.out.println();
    }
}
