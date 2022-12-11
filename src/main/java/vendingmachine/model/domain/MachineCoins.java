package vendingmachine.model.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class MachineCoins {
    private final Map<Coin, Integer> countByCoin;

    public MachineCoins(CoinsMaker coinsMaker, int holdingAmount) {
        this.countByCoin = coinsMaker.make(holdingAmount);
    }

    public Map<Coin, Integer> getCountByCoin() {
        return Collections.unmodifiableMap(countByCoin);
    }

    public Map<Coin, Integer> giveChangeCoins(int changeAmount) {
        Map<Coin, Integer> countByChangeCoin = new EnumMap<>(Coin.class);
        int remainingAmount = changeAmount;
        for (Coin coin : countByCoin.keySet()) {
            int maxCount = computeMaxCountForAmount(coin, remainingAmount);
            takeOutCoin(coin, maxCount);
            countByChangeCoin.put(coin, maxCount);
            remainingAmount -= (coin.getAmount() * maxCount);
        }
        return countByChangeCoin;
    }

    private void takeOutCoin(Coin coin, int count) {
        countByCoin.put(coin, countByCoin.get(coin) - count);
    }

    private int computeMaxCountForAmount(Coin coin, int remainingAmount) {
        int maxMultipleCount = remainingAmount / coin.getAmount();
        int holdingCount = countByCoin.get(coin);
        return Math.min(maxMultipleCount, holdingCount);
    }

    @Override
    public String toString() {
        return "MachineCoins{" +
                "countByCoin=" + countByCoin +
                '}';
    }
}
