package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ProductTest {

    @ParameterizedTest
    @ValueSource(strings = {"[콜라,1500,20];[사이다,1000,10]", "[콜라,1500,20];[사이다,1000,10];[환타,2000,30]"})
    void 상품의_정상적인_입력(String input) {
        assertThatCode(() -> new VendingMachineHasProducts(input)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"[,1500,20];[사이다,1000,10]", "[콜라,[1500,20];[사이다,1000,10]", "[콜라,,1500,20];[사이다,1000,10]", "[콜라,1500a,20];[사이다,1000,10]", "[콜라,1500a,20];[사이다,1000,a]", "[콜라,90,20];[사이다,1000,10]", "[콜라,1500,20];[사이다,1001,10]"})
    void 상품의_비정상적인_입력_예외처리(String input) {
        assertThatThrownBy(() -> new VendingMachineHasProducts(input)).isInstanceOf(IllegalArgumentException.class);
    }
}