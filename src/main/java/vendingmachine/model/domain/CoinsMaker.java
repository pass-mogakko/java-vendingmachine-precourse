package vendingmachine.model.domain;

import java.util.Map;

public interface CoinsMaker {
    Map<Coin, Integer> make(int holdingAmount);
}
