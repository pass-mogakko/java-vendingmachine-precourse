package vendingmachine.model.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public static int getMinimumAmount() {
        return COIN_10.amount;
    }

    public static List<Integer> getAllAmountTypes() {
        return Arrays.stream(values())
                .map(coin -> coin.amount)
                .collect(Collectors.toList());
    }

    public static Coin findByAmount(int amount) {
        return Arrays.stream(values())
                .filter(coin -> coin.amount == amount)
                .findFirst()
                .orElse(null);
    }
}
