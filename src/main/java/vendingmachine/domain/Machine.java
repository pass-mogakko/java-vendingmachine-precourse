package vendingmachine.domain;

import vendingmachine.domain.dto.response.CoinDto;
import vendingmachine.domain.dto.DtoBuilder;

import java.util.List;

public class Machine {
    private int setUpMoney;
    private int userMoney;
    private final Coins coins;
    private final Products products;

    public Machine(int machineMoney) {
        this.setUpMoney = machineMoney;
        this.userMoney = 0;
        this.coins = new Coins(machineMoney);
        this.products = new Products();
    }

    public List<CoinDto> createCoinDto() {
        DtoBuilder dtoBuilder = new DtoBuilder();
        return dtoBuilder.buildCoinDtos(coins);
    }

    public void setUserMoney(int userMoney) {
        this.userMoney = userMoney;
    }

    public void registerProduct(String name, int price, int count) {
        products.add(name, price, count);
    }

}
