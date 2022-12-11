package vendingmachine.model.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class ItemTest {
    @Test
    void 상품_정보_생성_가격이_10의_배수가_아니면_예외_발생() {
        assertThatThrownBy(() -> new Item("상품명", 1015))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 상품_정보_생성_가격이_100원_미만이면_예외_발생() {
        assertThatThrownBy(() -> new Item("상품명", 90))
                .isInstanceOf(IllegalArgumentException.class);
    }
}