package vendingmachine.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;
import static vendingmachine.domain.Coin.*;

public class Coins {
    private final Map<Coin, Integer> coins;

    public Coins() {
        this.coins = new HashMap<>();
    }

    public Map<Coin, Integer> generateRandomCoins(int machineMoney) {
        for (Coin coin : List.of(COIN_500, COIN_100, COIN_50)) {
            coins.put(coin, decideRandomCount(coin, machineMoney));
            machineMoney -= coin.getAmount() * coins.get(coin);
        }
        coins.put(COIN_10, machineMoney / COIN_10.getAmount());
        return coins;
    }

    public Map<Coin, Integer> generateResultCoins(int leftMoney) {
        for (Coin coin : Coin.values()) {
            coins.put(coin, leftMoney / coin.getAmount());
            leftMoney -= coin.getAmount() * coins.get(coin);
        }
        return coins;
    }

    private Integer decideRandomCount(Coin coin, int leftMoney) {
        int maxCount = leftMoney / coin.getAmount();
        if (maxCount > 0) {
            List<Integer> possibleRange = Stream.iterate(0, i -> i+1)
                    .limit(maxCount)
                    .collect(Collectors.toList());
            return pickNumberInList(possibleRange);
        }
        return 0;
    }

    public Map<Coin, Integer> getCoins() {
        return Collections.unmodifiableMap(coins);
    }

}
