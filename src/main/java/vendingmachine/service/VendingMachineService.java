package vendingmachine.service;

import java.util.Map;
import vendingmachine.domain.Coin;
import vendingmachine.domain.MoneyOfHumanInVendingMachine;
import vendingmachine.domain.RandomCoinGenerator;
import vendingmachine.domain.VendingMachineHasCoins;
import vendingmachine.domain.VendingMachineHasProducts;

public class VendingMachineService {

    private VendingMachineHasCoins vendingMachineHasCoins;
    private VendingMachineHasProducts vendingMachineHasProducts;
    private MoneyOfHumanInVendingMachine moneyOfHumanInVendingMachine;

    public Map<Integer, Integer> createRandomCoin(int money) {
        Map<Coin, Integer> randomCoins = RandomCoinGenerator.createRandomCoins(money);
        vendingMachineHasCoins = new VendingMachineHasCoins(randomCoins);
        return vendingMachineHasCoins.findAllCoins();
    }

    public void insertProducts(String products) {
        vendingMachineHasProducts = new VendingMachineHasProducts(products);
    }

    public void insertMoney(int money) {
        moneyOfHumanInVendingMachine = new MoneyOfHumanInVendingMachine(money);
    }

    public int findRemainingMoney() {
        return moneyOfHumanInVendingMachine.getMoney();
    }

    public void buyProduct(String productName) {
        int remainingMoney = moneyOfHumanInVendingMachine.getMoney();
        int productPrice = vendingMachineHasProducts.buy(productName, remainingMoney);
        moneyOfHumanInVendingMachine.spendMoney(productPrice);
    }

    public boolean isPossibleToBuy() {
        if (vendingMachineHasProducts.isAllSoldOut()) {
            return false;
        }
        int remainingMoney = moneyOfHumanInVendingMachine.getMoney();
        int lowestPrice = vendingMachineHasProducts.findProductLowestPrice();
        return remainingMoney >= lowestPrice;
    }

    public Map<Integer, Integer> takeChange() {
        int remainingMoney = moneyOfHumanInVendingMachine.getMoney();
        return vendingMachineHasCoins.takeChange(remainingMoney);
    }
}
