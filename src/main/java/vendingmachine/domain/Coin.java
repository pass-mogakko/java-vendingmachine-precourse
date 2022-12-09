package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.constant.ErrorMessage;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현

    public static Coin findCoinByAmount(int amount) {
        return Arrays.stream(Coin.values())
                .filter(coin -> coin.amount == amount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_FOUND_COIN));
    }

    public static List<Integer> findAllCoinAmount() {
        return Arrays.stream(Coin.values())
                .map(coin -> coin.amount)
                .collect(Collectors.toList());
    }

    public int getAmount() {
        return amount;
    }
}
