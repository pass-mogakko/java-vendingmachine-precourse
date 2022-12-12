package vendingmachine.domain;

import vendingmachine.domain.dto.CoinDto;
import vendingmachine.domain.dto.DtoBuilder;

import java.util.List;

import static vendingmachine.constant.ErrorMessage.INVALID_MACHINE_MONEY;
import static vendingmachine.constant.ErrorMessage.INVALID_MONEY_UNIT;
import static vendingmachine.constant.Setting.MINIMAL_MACHINE_MONEY;
import static vendingmachine.constant.Setting.MINIMAL_MONEY_UNIT;

public class Machine {
    private int money;
    private Coins coins;

    public Machine(int machineMoney) {
//        validateMachineMoney(machineMoney);
        this.money = machineMoney;
        this.coins = new Coins(machineMoney);
    }

//    private void validateMachineMoney(int money) {
//        if (money % MINIMAL_MONEY_UNIT != 0) {
//            throw new IllegalArgumentException(INVALID_MONEY_UNIT);
//        }
//        if (money < MINIMAL_MACHINE_MONEY) {
//            throw new IllegalArgumentException(INVALID_MACHINE_MONEY);
//        }
//    }

    public List<CoinDto> createCoinDto() {
        DtoBuilder dtoBuilder = new DtoBuilder();
        return dtoBuilder.buildCoinDtos(coins);
    }

}
