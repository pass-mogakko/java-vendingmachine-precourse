package vendingmachine.domain;

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
}
