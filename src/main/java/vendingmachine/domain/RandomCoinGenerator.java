package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RandomCoinGenerator {

    public static Map<Coin, Integer> createRandomCoins(int money) {
        Map<Coin, Integer> randomCoins = initRandomCoins();
        while (money > 0) {
            Coin randomCoin = createRandomCoin();
            if (randomCoin.getAmount() > money) {
                continue;
            }
            int coinCount = randomCoins.get(randomCoin);
            randomCoins.put(randomCoin, coinCount + 1);
            money -= randomCoin.getAmount();
        }
        return randomCoins;
    }

    private static Coin createRandomCoin() {
        int randomCoinAmount = Randoms.pickNumberInList(Coin.findAllCoinAmount());
        return Coin.findCoinByAmount(randomCoinAmount);
    }

    private static Map<Coin, Integer> initRandomCoins() {
        List<Integer> allCoinAmount = Coin.findAllCoinAmount();
        return allCoinAmount.stream()
                .collect(Collectors.toMap(Coin::findCoinByAmount, coinAmount -> 0));
    }
}
