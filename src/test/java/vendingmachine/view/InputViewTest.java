package vendingmachine.view;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"10", "100", "120"})
    void 자판기가_보유하고_있는_금액_정상적인_입력(String input) {
        assertThatCode(() -> InputView.validateVendingMachineHasCoin(input)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "10a", "b", "1", "123"})
    void 자판기가_보유하고_있는_금액_비정상적인_입력_예외처리(String input) {
        assertThatThrownBy(() -> InputView.validateVendingMachineHasCoin(input)).isInstanceOf(IllegalArgumentException.class);
    }
}