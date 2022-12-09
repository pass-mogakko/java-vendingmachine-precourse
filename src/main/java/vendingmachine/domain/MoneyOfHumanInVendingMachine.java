package vendingmachine.domain;

public class MoneyOfHumanInVendingMachine {

    private int money;

    public MoneyOfHumanInVendingMachine(int money) {
        this.money = money;
    }

    public void spendMoney(int productPrice) {
        money -= productPrice;
    }

    public int getMoney() {
        return money;
    }
}
