package vendingmachine.domain;

import vendingmachine.domain.dto.CoinDto;
import vendingmachine.domain.dto.DtoBuilder;

import java.util.List;

public class Machine {
    private int setUpMoney;
    private Coins coins;
    private int userMoney;

    public Machine(int machineMoney) {
        this.setUpMoney = machineMoney;
        this.coins = new Coins(machineMoney);
        this.userMoney = 0;
    }

    public List<CoinDto> createCoinDto() {
        DtoBuilder dtoBuilder = new DtoBuilder();
        return dtoBuilder.buildCoinDtos(coins);
    }

    public void setUserMoney(int userMoney) {
        this.userMoney = userMoney;
    }
}
