package vendingmachine.domain;

import vendingmachine.domain.dto.response.CoinDto;
import vendingmachine.domain.dto.DtoBuilder;

import java.util.List;

import static vendingmachine.constant.ErrorMessage.*;

public class Machine {
    private final int setUpMoney;
    private final Coins setUpCoins;
    private final Products products;
    private int minPrice;
    private int userMoney;

    private final DtoBuilder dtoBuilder = new DtoBuilder();

    public Machine(int machineMoney) {
        this.setUpMoney = machineMoney;
        this.userMoney = 0;
        this.setUpCoins = new Coins();
        this.products = new Products();
        this.minPrice = Integer.MAX_VALUE;
    }

    public void setUpRandomCoins(int machineMoney) {
        setUpCoins.generateRandomCoins(machineMoney);
    }

    public void setUserMoney(int userMoney) {
        this.userMoney = userMoney;
    }

    public int getUserMoney() {
        return userMoney;
    }

    public List<CoinDto> generateInitCoinDto() {
        return dtoBuilder.buildCoinDtos(setUpCoins);
    }

    public List<CoinDto> generateResultCoinDtos() {
        Coins coins = new Coins();
        coins.generateResultCoins(userMoney);
        return dtoBuilder.buildCoinDtos(coins);
    }

    public void registerProduct(String name, int price, int count) {
        products.add(name, price, count);
        updateMinPrice(price);
    }

    private void updateMinPrice(int price) {
        if (minPrice > price) {
            minPrice = price;
        }
    }

    public void consumeProduct(String productName) {
        Product product = products.findByName(productName)
                .orElseThrow(() -> new IllegalArgumentException(PRODUCT_NOT_FOUND));

        userMoney -= product.getPrice();
        products.consume(product);
    }

    public boolean available() {
        int totalStock = products.getProducts().values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        return (userMoney > minPrice && totalStock > 0);
    }

}
