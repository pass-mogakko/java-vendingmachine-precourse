package vendingmachine.domain.dto;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.domain.dto.request.ProductDto;
import vendingmachine.domain.dto.response.CoinDto;

import java.util.ArrayList;
import java.util.List;

public class DtoBuilder {

    public List<CoinDto> buildCoinDtos(Coins coins) {
        List<CoinDto> coinDtos = new ArrayList<>();

        for (Coin coin : Coin.values()) {
            CoinDto coinDto = buildCoinDto(coin, coins);
            coinDtos.add(coinDto);
        }
        return coinDtos;
    }

    private CoinDto buildCoinDto(Coin coin, Coins coins) {
        String coinName = coin.getKoreanName();
        int count = coins.getCoins().get(coin);
        return new CoinDto(coinName, count);
    }

    public List<ProductDto> buildProductDtos(String input) {
        List<ProductDto> productDtos = new ArrayList<>();

        List<String> rawData = List.of(input.split(";"));
        for (String productData : rawData) {
            ProductDto productDto = buildProductDto(productData);
            productDtos.add(productDto);
        }
        return productDtos;
    }

    private ProductDto buildProductDto(String data) {
        List<String> productData = List.of(data.substring(1, data.length() - 1).split(","));

        String name = productData.get(0);
        int price = Integer.parseInt(productData.get(1));
        int count = Integer.parseInt(productData.get(2));

        return new ProductDto(name, price, count);
    }
}
