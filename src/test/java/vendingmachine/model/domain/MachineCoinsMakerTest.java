package vendingmachine.model.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MachineCoinsMakerTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 450, 1000, 7890})
    void 동전_생성_성공(int holdingAmount) {
        MachineCoinsMaker machineCoinsMaker = new MachineCoinsMaker();
        Map<Coin, Integer> countByCoin = machineCoinsMaker.make(holdingAmount);
        int coinTotalAmount = countByCoin.keySet()
                .stream()
                .map(coin -> (coin.getAmount()) * countByCoin.get(coin))
                .reduce(0, Integer::sum);

        System.out.println(countByCoin);
        assertThat(countByCoin).hasSize(Coin.values().length);
        assertThat(holdingAmount - (holdingAmount % Coin.getMinimumAmount())).isEqualTo(coinTotalAmount);
    }

    @Test
    void 동전_생성_보유금액_10의_배수가_아니면_예외발생() {
        MachineCoinsMaker machineCoinsMaker = new MachineCoinsMaker();

        assertThatThrownBy(() -> machineCoinsMaker.make(5)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 동전_생성_보유금액_음수이면_예외발생() {
        MachineCoinsMaker machineCoinsMaker = new MachineCoinsMaker();

        assertThatThrownBy(() -> machineCoinsMaker.make(-1000)).isInstanceOf(IllegalArgumentException.class);
    }
}