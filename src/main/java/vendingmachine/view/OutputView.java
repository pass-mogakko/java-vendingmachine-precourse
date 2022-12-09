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
        printCoins(vendingMachineHasCoins);
    }

    public static void printRemainingMoney(int money) {
        System.out.println();
        System.out.printf(MessageForm.REMAINING_MONEY, money);
        System.out.println();
    }

    public static void printChange(Map<Integer, Integer> changeAndChangeCount) {
        System.out.println(Message.CHANGE);
        printCoins(changeAndChangeCount);
    }

    private static void printCoins(Map<Integer, Integer> coinAmountAndCoinCount) {
        ArrayList<Integer> coinAmounts = new ArrayList<>(coinAmountAndCoinCount.keySet());
        Collections.sort(coinAmounts);
        Collections.reverse(coinAmounts);
        coinAmounts.forEach(coinAmount -> printCoins(coinAmount, coinAmountAndCoinCount.get(coinAmount)));
    }

    private static void printCoins(int coinAmount, int coinCount) {
        System.out.printf(MessageForm.COIN_COUNT_MESSAGE_FORM, coinAmount, coinCount);
        System.out.println();
    }
}
