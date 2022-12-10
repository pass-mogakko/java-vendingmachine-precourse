package vendingmachine.model.domain;

import java.util.Map;

public class MachineCoins {
    private final Map<Coin, Integer> countByCoin;

    public MachineCoins(CoinsMaker coinsMaker, int holdingAmount) {
        this.countByCoin = coinsMaker.make(holdingAmount);
    }

    @Override
    public String toString() {
        return "MachineCoins{" +
                "countByCoin=" + countByCoin +
                '}';
    }
}
