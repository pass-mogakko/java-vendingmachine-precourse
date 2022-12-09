package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class RandomCoinGenerator {

    public static Map<Coin, Integer> createRandomCoins(int money) {
        Map<Coin, Integer> randomCoins = new HashMap<>();
        while (money > 0) {
            Coin randomCoin = createRandomCoin();
            if (randomCoin.getAmount() > money) {
                continue;
            }
            int coinCount = randomCoins.getOrDefault(randomCoin, 0);
            randomCoins.put(randomCoin, coinCount + 1);
        }
        return randomCoins;
    }

    private static Coin createRandomCoin() {
        int randomCoinAmount = Randoms.pickNumberInList(Coin.findAllCoinAmount());
        return Coin.findCoinByAmount(randomCoinAmount);
    }
}
