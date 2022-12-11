package vendingmachine.view;

import static vendingmachine.view.constants.OutputFormat.COUNT_BY_COIN;
import static vendingmachine.view.constants.OutputFormat.ERROR;
import static vendingmachine.view.constants.OutputFormat.INSERTED_AMOUNT;

import java.util.List;
import vendingmachine.dto.CoinDTO;
import vendingmachine.view.constants.OutputMessage;

public class OutputView {
    public void printMachineCoins(List<CoinDTO> machineCoins) {
        System.out.println(OutputMessage.MACHINE_COINS);
        machineCoins.forEach(this::printCountByCoin);
        System.out.println();
    }

    public void printInsertedAmount(int insertedAmount) {
        System.out.printf(INSERTED_AMOUNT, insertedAmount);
    }

    public void printChangeCoins(List<CoinDTO> changeCoins) {
        System.out.println(OutputMessage.CHANGE_COINS);
        if (changeCoins.isEmpty()) {
            System.out.println(OutputMessage.CHANGE_COINS_EMPTY);
            return;
        }
        changeCoins.stream()
                .filter(coin -> coin.getCount() > 0)
                .forEach(this::printCountByCoin);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.printf(ERROR, errorMessage);
    }

    private void printCountByCoin(CoinDTO coin) {
        System.out.printf(COUNT_BY_COIN, coin.getAmount(), coin.getCount());
    }
}
