package vendingmachine.model.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import vendingmachine.model.constants.ErrorMessage;

public class MachineCoinsMaker implements CoinsMaker {
    @Override
    public Map<Coin, Integer> make(int holdingAmount) {
        Map<Coin, Integer> countByCoin = initializeCountByCoin();
        validateHoldingAmount(holdingAmount);
        setCountByCoin(countByCoin, holdingAmount);
        return countByCoin;
    }

    private Map<Coin, Integer> initializeCountByCoin() {
        Map<Coin, Integer> countByCoin = new EnumMap<>(Coin.class);
        Arrays.stream(Coin.values())
                .forEach(coin -> countByCoin.put(coin, 0));
        return countByCoin;
    }

    private void validateHoldingAmount(int holdingAmount) {
        if (holdingAmount < 0) {
            throw new IllegalArgumentException(ErrorMessage.HOLDING_AMOUNT_OUT_OF_BOUNDS);
        }
        if ((holdingAmount % Coin.getMinimumAmount()) != 0) {
            throw new IllegalArgumentException(ErrorMessage.HOLDING_AMOUNT_INVALID_MULTIPLE);
        }
    }

    private void setCountByCoin(Map<Coin, Integer> countByCoin, int holdingAmount) {
        while (holdingAmount >= Coin.getMinimumAmount()) {
            int coinAmount = Randoms.pickNumberInList(Coin.getAllAmountTypes());
            if ((holdingAmount - coinAmount) < 0) {
                continue;
            }
            holdingAmount -= coinAmount;
            Coin coin = Coin.findByAmount(coinAmount);
            countByCoin.put(coin, countByCoin.getOrDefault(coin, 0) + 1);
        }
    }
}
