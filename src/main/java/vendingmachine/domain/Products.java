package vendingmachine.domain;

import java.util.*;

public class Products {
    private Map<Product, Integer> products;

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
}
