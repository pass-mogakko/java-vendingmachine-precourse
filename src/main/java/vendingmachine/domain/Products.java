package vendingmachine.domain;

import java.util.*;

public class Products {
    private final Map<Product, Integer> products;

    public Products() {
        products = new HashMap<>();
    }

    public Map<Product, Integer> getProducts() {
        return Collections.unmodifiableMap(products);
    }

    public void add(String name, int price, int count) {
        Product product = new Product(name, price);
        products.put(product, count);
    }

    Optional<Product> findByName(String name) {
        return products.keySet().stream()
                .filter(product -> product.nameEquals(name))
                .findFirst();
    }

    public void consume(Product targetProduct) {
        int nowCnt = products.get(targetProduct);
        products.replace(targetProduct, nowCnt - 1);
    }
}
