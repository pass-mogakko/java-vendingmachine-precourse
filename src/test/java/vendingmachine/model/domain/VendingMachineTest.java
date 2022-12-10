package vendingmachine.model.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class VendingMachineTest {
    @Test
    void 투입_금액_저장_투입_금액이_0보다_작으면_예외_발생() {
        VendingMachine vendingMachine = new VendingMachine();
        assertThatThrownBy(() -> vendingMachine.insertMoney(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}