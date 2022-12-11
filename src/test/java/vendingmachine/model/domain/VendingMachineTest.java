package vendingmachine.model.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Maps.newHashMap;

import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class VendingMachineTest {
    @Test
    void 상품_목록_저장_모든_상품_수량의_총_합이_0인_경우_예외_발생() {
        VendingMachine vendingMachine = new VendingMachine();

        assertThatThrownBy(() -> vendingMachine.setItems(new MachineItems(Map.of(
                new Item("아이템명1", 1000), 0,
                new Item("아이템명2", 1000), 0,
                new Item("아이템명3", 1000), 0
        )))).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {510})
    void 투입_금액_저장_성공(int insertAmount) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setItems(new MachineItems(newHashMap(new Item("상품명", 500), 1)));
        vendingMachine.insertMoney(insertAmount);

        assertThat(vendingMachine.getInsertedAmount()).isEqualTo(insertAmount);
    }

    @Test
    void 투입_금액_저장_투입_금액이_0_이하이면_예외_발생() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setItems(new MachineItems(newHashMap(new Item("상품명", 500), 1)));

        assertThatThrownBy(() -> vendingMachine.insertMoney(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 투입_금액_저장_투입_금액이_10의_배수가_아니면_예외_발생() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setItems(new MachineItems(newHashMap(new Item("상품명", 500), 1)));

        assertThatThrownBy(() -> vendingMachine.insertMoney(5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 투입_금액_저장_투입_금액이_상품_최저금액보다_작으면_예외_발생() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setItems(new MachineItems(newHashMap(new Item("상품명", 500), 1)));

        assertThatThrownBy(() -> vendingMachine.insertMoney(490))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 상품_구매_성공() {
        VendingMachine vendingMachine = new VendingMachine();
        MachineItems machineItems = new MachineItems(newHashMap(new Item("상품명", 500), 1));
        vendingMachine.setItems(machineItems);
        vendingMachine.insertMoney(1000);
        vendingMachine.sellItem("상품명");

        assertThat(vendingMachine.getInsertedAmount()).isEqualTo(500);
        assertThat(machineItems.sumQuantity()).isEqualTo(0);
    }

    @Test
    void 상품_구매_존재하지_않는_상품명이면_예외_발생() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setItems(new MachineItems(newHashMap(new Item("상품명", 500), 1)));
        vendingMachine.insertMoney(1000);

        assertThatThrownBy(() -> vendingMachine.sellItem("잘못된상품명"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 상품_구매_상품의_수량이_0이면_예외_발생() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setItems(new MachineItems(newHashMap(new Item("상품명", 500), 1)));
        vendingMachine.insertMoney(1000);
        vendingMachine.sellItem("상품명");

        assertThatThrownBy(() -> vendingMachine.sellItem("상품명"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매_가능_확인_참() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setItems(new MachineItems(newHashMap(new Item("상품명", 500), 1)));
        vendingMachine.insertMoney(1000);

        assertThat(vendingMachine.isAvailable()).isTrue();
    }

    @Test
    void 구매_가능_확인_남은_투입_금액이_상품_최저_가격보다_작으면_거짓() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setItems(new MachineItems(newHashMap(new Item("상품명", 500), 1)));
        vendingMachine.insertMoney(900);
        vendingMachine.sellItem("상품명");

        assertThat(vendingMachine.isAvailable()).isFalse();
    }

    @Test
    void 구매_가능_확인_남은_상품_수량이_0이면_거짓() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setItems(new MachineItems(newHashMap(new Item("상품명", 500), 1)));
        vendingMachine.insertMoney(5000);
        vendingMachine.sellItem("상품명");

        assertThat(vendingMachine.isAvailable()).isFalse();
    }
}