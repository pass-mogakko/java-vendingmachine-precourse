package vendingmachine.view;

import static vendingmachine.view.constants.OutputFormat.INSERTED_AMOUNT;
import static vendingmachine.view.constants.OutputFormat.MACHINE_COIN;

import java.util.List;
import vendingmachine.dto.CoinDTO;
import vendingmachine.view.constants.OutputMessage;

public class OutputView {
    public void printMachineCoins(List<CoinDTO> machineCoins) {
        System.out.println(OutputMessage.MACHINE_COINS);
        machineCoins.forEach(coin -> System.out.printf(MACHINE_COIN, coin.getAmount(), coin.getCount()));
        System.out.println();
    }

    public void printInsertedAmount(int insertedAmount) {
        System.out.printf(INSERTED_AMOUNT, insertedAmount);
    }
}
