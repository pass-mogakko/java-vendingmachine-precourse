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

    public static List<CoinDTO> toDTO(Map<Coin, Integer> quantityByCoin) {
        return quantityByCoin.keySet()
                .stream()
                .map(coin -> new CoinDTO(coin.getAmount(), quantityByCoin.get(coin)))
                .collect(Collectors.toList());
    }

    public static List<CoinDTO> toDTOWithOutZeroValue(Map<Coin, Integer> quantityByCoin) {
        return quantityByCoin.keySet()
                .stream()
                .filter(coin -> quantityByCoin.get(coin) > 0)
                .map(coin -> new CoinDTO(coin.getAmount(), quantityByCoin.get(coin)))
                .collect(Collectors.toList());
    }
}
