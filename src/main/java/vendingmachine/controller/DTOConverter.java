package vendingmachine.controller;

import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.dto.ItemDTO;
import vendingmachine.model.domain.Item;

public class DTOConverter {
    public static List<Item> convert(List<ItemDTO> itemDTOs) {
        return itemDTOs.stream()
                .map(itemDTO -> new Item(itemDTO.getName(), itemDTO.getPrice(), itemDTO.getQuantity()))
                .collect(Collectors.toList());
    }
}
