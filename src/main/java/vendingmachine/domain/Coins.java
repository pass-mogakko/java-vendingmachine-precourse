package vendingmachine.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;
import static vendingmachine.domain.Coin.*;

public class Coins {
    private Map<Coin, Integer> coins;

    public Coins(int machineMoney) {
        this.coins = generateCoins(machineMoney);
    }

    public Map<Coin, Integer> generateCoins(int machineMoney) {
        HashMap<Coin, Integer> tmp = new HashMap<>();
        for (Coin coin : List.of(COIN_500, COIN_100, COIN_50)) {
            tmp.put(coin, generateCoinRange(coin, machineMoney));
            machineMoney -= coin.getAmount() * tmp.get(coin);
        }
        tmp.put(COIN_10, machineMoney / COIN_10.getAmount());
        return tmp;
    }

    private Integer generateCoinRange(Coin coin, int leftMoney) {
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
