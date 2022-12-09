package vendingmachine.service;

import java.util.Map;
import vendingmachine.domain.Coin;
import vendingmachine.domain.RandomCoinGenerator;
import vendingmachine.domain.VendingMachineHasCoins;
import vendingmachine.domain.VendingMachineHasProducts;

public class VendingMachineService {

    private VendingMachineHasCoins vendingMachineHasCoins;
    private VendingMachineHasProducts vendingMachineHasProducts;

    public Map<Integer, Integer> createRandomCoin(int money) {
        Map<Coin, Integer> randomCoins = RandomCoinGenerator.createRandomCoins(money);
        vendingMachineHasCoins = new VendingMachineHasCoins(randomCoins);
        return vendingMachineHasCoins.findAllCoins();
    }

    public void insertProducts(String products) {
        vendingMachineHasProducts = new VendingMachineHasProducts(products);
    }
}
