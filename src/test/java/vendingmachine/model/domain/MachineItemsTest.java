package vendingmachine.model.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Map;
import org.junit.jupiter.api.Test;

class MachineItemsTest {
    @Test
    void 상품_목록_생성_상품_수량_정보가_0보다_작으면_예외_발생() {
        assertThatThrownBy(() -> new MachineItems(Map.of(
                new Item("아이템명1", 1000), 1,
                new Item("아이템명2", 1000), 2,
                new Item("아이템명3", 1000), -1
        ))).isInstanceOf(IllegalArgumentException.class);
    }
}