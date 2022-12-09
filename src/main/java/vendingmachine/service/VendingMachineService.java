package vendingmachine.service;

import java.util.Map;
import vendingmachine.domain.Coin;
import vendingmachine.domain.RandomCoinGenerator;
import vendingmachine.domain.VendingMachineHasCoins;

public class VendingMachineService {

    private VendingMachineHasCoins vendingMachineHasCoins;

    public void createRandomCoin(int money) {
        Map<Coin, Integer> randomCoins = RandomCoinGenerator.createRandomCoins(money);
        vendingMachineHasCoins = new VendingMachineHasCoins(randomCoins);
    }
}
