package vendingmachine.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import vendingmachine.dto.CoinDTO;
import vendingmachine.dto.ItemDTO;
import vendingmachine.model.domain.Coin;
import vendingmachine.model.domain.Item;

public class DTOConverter {
    public static List<Item> toEntity(List<ItemDTO> itemDTOs) {
        return itemDTOs.stream()
                .map(itemDTO -> new Item(itemDTO.getName(), itemDTO.getPrice(), itemDTO.getQuantity()))
                .collect(Collectors.toList());
    }

    public static List<CoinDTO> toDTO(Map<Coin, Integer> countByCoins) {
        return countByCoins.keySet()
                .stream()
                .map(coin -> new CoinDTO(coin.getAmount(), countByCoins.get(coin)))
                .collect(Collectors.toList());
    }
}
