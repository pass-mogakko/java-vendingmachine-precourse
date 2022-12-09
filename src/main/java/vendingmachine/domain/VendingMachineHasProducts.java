package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.constant.Constant;
import vendingmachine.constant.ErrorMessage;

public class VendingMachineHasProducts {

    private final List<Product> products;

    public VendingMachineHasProducts(String userInput) {
        products = Arrays.stream(userInput.split(Constant.PRODUCTS_SPLIT_REGEX))
                .map(Product::new)
                .collect(Collectors.toList());
    }

    public int buy(String productName, int remainingMoney) {
        Product product = findProductByName(productName);
        if (remainingMoney < product.getPrice()) {
            throw new IllegalArgumentException(ErrorMessage.LACK_MONEY);
        }
        product.buy();
        return product.getPrice();
    }

    private Product findProductByName(String name) {
        return products.stream()
                .filter(product -> product.isSameName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_FOUND_PRODUCT));
    }

    public int findProductLowestPrice() {
        return products.stream()
                .filter(product -> !product.isSoldOut())
                .mapToInt(Product::getPrice)
                .min()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.ALL_PRODUCT_SOLD_OUT));
    }

    public boolean isAllSoldOut() {
        return products.stream()
                .allMatch(Product::isSoldOut);
    }
}
