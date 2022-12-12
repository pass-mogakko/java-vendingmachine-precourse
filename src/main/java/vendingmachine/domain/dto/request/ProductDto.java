package vendingmachine.domain.dto.request;

public class ProductDto {
    private String name;
    private int price;
    private int count;

    public ProductDto(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

}
