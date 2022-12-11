package vendingmachine.model.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static vendingmachine.model.domain.Coin.COIN_10;
import static vendingmachine.model.domain.Coin.COIN_100;
import static vendingmachine.model.domain.Coin.COIN_50;
import static vendingmachine.model.domain.Coin.COIN_500;

import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class MachineCoinsTest {

    @Test
    void 잔돈_반환_성공() {
        MachineCoins machineCoins = new MachineCoins(
                amount -> new EnumMap<>(Map.of(COIN_500, 1, COIN_100, 3, COIN_50, 0, COIN_10, 3)), 830);
        Map<Coin, Integer> countByChangeCoin = machineCoins.giveChangeCoins(710);

        assertThat(countByChangeCoin.values())
                .containsExactly(1, 2, 0, 1);
        assertThat(machineCoins.getQuantityByCoin().values())
                .containsExactly(0, 1, 0, 2);
    }
}