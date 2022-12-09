package vendingmachine.domain;

import java.util.Map;

public class VendingMachineHasCoins {

    private final Map<Coin, Integer> coins;

    public VendingMachineHasCoins(Map<Coin, Integer> coins) {
        this.coins = coins;
    }
}
