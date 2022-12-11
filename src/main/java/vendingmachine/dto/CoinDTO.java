package vendingmachine.dto;

public class CoinDTO {
    private final int amount;
    private final int count;

    public CoinDTO(int amount, int count) {
        this.amount = amount;
        this.count = count;
    }

    public int getAmount() {
        return amount;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "CoinDTO{" +
                "amount=" + amount +
                ", count=" + count +
                '}';
    }
}
