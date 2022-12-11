package vendingmachine.model.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Maps.newHashMap;

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

    @Test
    void 상품_구매_성공() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertMoney(1000);
        MachineItems machineItems = new MachineItems(newHashMap(new Item("상품명", 500), 1));
        vendingMachine.insertItems(machineItems);
        vendingMachine.sellItem("상품명");

        assertThat(vendingMachine.getInsertedAmount()).isEqualTo(500);
        assertThat(machineItems.sumQuantity()).isEqualTo(0);
    }

    @Test
    void 상품_구매_존재하지_않는_상품명이면_예외_발생() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertMoney(1000);
        vendingMachine.insertItems(new MachineItems(newHashMap(new Item("상품명", 500), 1)));

        assertThatThrownBy(() -> vendingMachine.sellItem("잘못된상품명"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 상품_구매_상품의_수량이_0이면_예외_발생() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertMoney(1000);
        vendingMachine.insertItems(new MachineItems(newHashMap(new Item("상품명", 500), 1)));
        vendingMachine.sellItem("상품명");

        assertThatThrownBy(() -> vendingMachine.sellItem("상품명"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매_가능_확인_참() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertMoney(1000);
        vendingMachine.insertItems(new MachineItems(newHashMap(new Item("상품명", 500), 1)));

        assertThat(vendingMachine.isAvailable()).isTrue();
    }

    @Test
    void 구매_가능_확인_남은_투입_금액이_상품_최저_가격보다_작으면_거짓() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertMoney(100);
        vendingMachine.insertItems(new MachineItems(newHashMap(new Item("상품명", 500), 1)));

        assertThat(vendingMachine.isAvailable()).isFalse();
    }

    @Test
    void 구매_가능_확인_남은_상품_수량이_0이면_거짓() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertMoney(5000);
        vendingMachine.insertItems(new MachineItems(newHashMap(new Item("상품명", 500), 1)));
        vendingMachine.sellItem("상품명");

        assertThat(vendingMachine.isAvailable()).isFalse();
    }
}