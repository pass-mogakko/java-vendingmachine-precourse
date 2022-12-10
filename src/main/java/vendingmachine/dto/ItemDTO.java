package vendingmachine.dto;

public class ItemDTO {
    private final String name;
    private final int price;
    private final int quantity;

    public ItemDTO(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
