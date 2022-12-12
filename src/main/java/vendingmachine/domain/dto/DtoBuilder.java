package vendingmachine.domain.dto;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;

import java.util.ArrayList;
import java.util.List;

public class DtoBuilder {

    public List<CoinDto> buildCoinDtos(Coins coins) {
        List<CoinDto> coinDtos = new ArrayList<>();
        for (Coin coin : Coin.values()) {
            CoinDto coinDto = new CoinDto(coin.getKoreanName(), coins.getCoins().get(coin));
            coinDtos.add(coinDto);
        }
        return coinDtos;
    }

}
