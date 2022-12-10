package vendingmachine.model.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class MachineItemsTest {
    @Test
    void 상품_목록_저장_모든_상품_수량의_총_합이_0인_경우_예외_발생() {
        assertThatThrownBy(() -> new MachineItems(List.of(
                new Item("아이템명1", 1000, 0),
                new Item("아이템명2", 1000, 0),
                new Item("아이템명3", 1000, 0)
        ))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 상품_목록_저장_중복된_상품명이_존재하는_경우_예외_발생() {
        assertThatThrownBy(() -> new MachineItems(List.of(
                new Item("아이템명1", 1000, 1),
                new Item("아이템명1", 1000, 1),
                new Item("아이템명3", 1000, 1)
        ))).isInstanceOf(IllegalArgumentException.class);
    }
}