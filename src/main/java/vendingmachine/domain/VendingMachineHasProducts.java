package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.constant.Constant;

public class VendingMachineHasProducts {

    private final List<Product> products;

    public VendingMachineHasProducts(String userInput) {
        products = Arrays.stream(userInput.split(Constant.PRODUCTS_SPLIT_REGEX))
                .map(Product::new)
                .collect(Collectors.toList());
    }
}
