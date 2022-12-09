package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class VendingMachineHasCoins {

    private final Map<Coin, Integer> coinAndCoinCount;

    public VendingMachineHasCoins(Map<Coin, Integer> coinAndCoinCount) {
        this.coinAndCoinCount = coinAndCoinCount;
    }

    public Map<Integer, Integer> findAllCoins() {
        return coinAndCoinCount.keySet()
                .stream()
                .collect(Collectors.toMap(Coin::getAmount, coinAndCoinCount::get));
    }

    public Map<Integer, Integer> takeChange(int remainingMoney) {
        Map<Integer, Integer> coinAmountAndCoinCount = new HashMap<>();
        for (Coin coin : Coin.values()) {
            int coinCount = remainingMoney / coin.getAmount();
            if (coinCount > coinAndCoinCount.get(coin)) {
                coinCount = coinAndCoinCount.get(coin);
            }
            if (coinCount == 0) {
                continue;
            }
            coinAmountAndCoinCount.put(coin.getAmount(), coinCount);
            remainingMoney -= coinCount * coin.getAmount();
        }
        return coinAmountAndCoinCount;
    }
}
