package vendingmachine.model.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class MachineCoins {
    private final Map<Coin, Integer> quantityByCoin;

    public MachineCoins(CoinsMaker coinsMaker, int holdingAmount) {
        this.quantityByCoin = coinsMaker.make(holdingAmount);
    }

    public Map<Coin, Integer> getQuantityByCoin() {
        return Collections.unmodifiableMap(quantityByCoin);
    }

    public Map<Coin, Integer> giveChangeCoins(int changeAmount) {
        Map<Coin, Integer> quantityByChangeCoin = new EnumMap<>(Coin.class);
        int remainingAmount = changeAmount;
        for (Coin coin : quantityByCoin.keySet()) {
            int maxQuantity = computeMaxQuantityForAmount(coin, remainingAmount);
            takeOutCoin(coin, maxQuantity);
            quantityByChangeCoin.put(coin, maxQuantity);
            remainingAmount -= (coin.getAmount() * maxQuantity);
        }
        return quantityByChangeCoin;
    }

    private void takeOutCoin(Coin coin, int quantity) {
        quantityByCoin.put(coin, quantityByCoin.get(coin) - quantity);
    }

    private int computeMaxQuantityForAmount(Coin coin, int remainingAmount) {
        int multipleQuantity = remainingAmount / coin.getAmount();
        int holdingCount = quantityByCoin.get(coin);
        return Math.min(multipleQuantity, holdingCount);
    }

    @Override
    public String toString() {
        return "MachineCoins{" +
                "countByCoin=" + quantityByCoin +
                '}';
    }
}
