package vendingmachine.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import vendingmachine.dto.CoinDTO;
import vendingmachine.dto.ItemDTO;
import vendingmachine.model.domain.Coin;
import vendingmachine.model.domain.Item;

public class DTOConverter {
    public static Map<Item, Integer> toEntity(List<ItemDTO> itemDTOs) {
        return itemDTOs.stream()
                .collect(Collectors.toMap(item -> new Item(item.getName(), item.getPrice()),
                        item -> item.getQuantity()));
    }

    public static List<CoinDTO> toDTO(Map<Coin, Integer> countByCoins) {
        return countByCoins.keySet()
                .stream()
                .map(coin -> new CoinDTO(coin.getAmount(), countByCoins.get(coin)))
                .collect(Collectors.toList());
    }

    public static List<CoinDTO> toDTOWithOutZeroCount(Map<Coin, Integer> countByCoins) {
        return countByCoins.keySet()
                .stream()
                .filter(coin -> countByCoins.get(coin) > 0)
                .map(coin -> new CoinDTO(coin.getAmount(), countByCoins.get(coin)))
                .collect(Collectors.toList());
    }
}
