package vendingmachine.model.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class VendingMachineTest {
    @Test
    void 투입_금액_저장_투입_금액이_0보다_작으면_예외_발생() {
        VendingMachine vendingMachine = new VendingMachine(
                new MachineCoins(new MachineCoinsMaker(), 0), new MachineItems(List.of(new Item("아이템명", 1000, 1)))
        );
        assertThatThrownBy(() -> vendingMachine.insertMoney(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}