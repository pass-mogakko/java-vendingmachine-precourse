package vendingmachine.model.domain;

import java.util.Map;

public class MachineCoins {
    private final Map<Coin, Integer> countByCoin;

    public MachineCoins(CoinsMaker coinsMaker, int hodlingAmount) {
        this.countByCoin = coinsMaker.make(hodlingAmount);
    }
}
