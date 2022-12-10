package vendingmachine.model.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class VendingMachineTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 7, 1000})
    void 투입_금액_저장_성공(int insertAmount) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertMoney(insertAmount);

        assertThat(vendingMachine.getInsertedAmount()).isEqualTo(insertAmount);
    }

    @Test
    void 투입_금액_저장_투입_금액이_0보다_작으면_예외_발생() {
        VendingMachine vendingMachine = new VendingMachine();
        assertThatThrownBy(() -> vendingMachine.insertMoney(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}