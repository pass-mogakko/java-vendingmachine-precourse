package vendingmachine.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import vendingmachine.constant.Message;
import vendingmachine.constant.MessageForm;

public class OutputView {

    public static void printErrorMessage(String message) {
        System.out.println();
        System.out.printf(MessageForm.ERROR_MESSAGE_FORM, message);
        System.out.println();
    }

    public static void printVendingMachineHasCoins(Map<Integer, Integer> vendingMachineHasCoins) {
        System.out.println();
        System.out.println(Message.VENDING_MACHINE_HAS_COINS);
        ArrayList<Integer> coinAmounts = new ArrayList<>(vendingMachineHasCoins.keySet());
        Collections.sort(coinAmounts);
        Collections.reverse(coinAmounts);
        coinAmounts.forEach(coinAmount -> printVendingMachineHasCoin(coinAmount, vendingMachineHasCoins.get(coinAmount)));
    }

    private static void printVendingMachineHasCoin(int coinAmount, int coinCount) {
        System.out.printf(MessageForm.COIN_COUNT_MESSAGE_FORM, coinAmount, coinCount);
        System.out.println();
    }
}
