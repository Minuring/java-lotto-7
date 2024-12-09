package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PurchasedLottoTest {

    Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    Lotto lotto2 = new Lotto(List.of(12, 11, 10, 9, 8, 7));
    PurchasedLotto purchasedLotto = new PurchasedLotto(List.of(lotto1, lotto2));

    WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

    @DisplayName("발행한 로또의 수량을 알 수 있다.")
    @Test
    void countPurchasedLotto() {
        assertThat(purchasedLotto.count()).isEqualTo(2);
    }

    @DisplayName("toString은 발행한 로또의 번호를 오름차순으로 리턴한다.")
    @Test
    void toStringPurchasedLotto() {
        assertThat(purchasedLotto.toString())
            .contains("[1, 2, 3, 4, 5, 6]")
            .contains("[7, 8, 9, 10, 11, 12]");
    }

    @DisplayName("구입한 로또들이 등수별로 몇 개가 당첨되었는 지 알 수 있다.")
    @ParameterizedTest
    @MethodSource("purchasedLottoTestData")
    void countRanks(PurchasedLotto purchasedLotto) {
        Map<Rank, Long> countedRanks = purchasedLotto.countRanks(winningLotto);
        assertThat(countedRanks.get(Rank.FIFTH)).isEqualTo(1L); //5등 당첨 1개
        assertThat(countedRanks.get(Rank.NONE)).isEqualTo(7L); //꽝 7개
        assertThat(countedRanks.keySet()).doesNotContain(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH);
    }

    @DisplayName("구입한 로또들의 수익률을 알 수 있다.")
    @ParameterizedTest
    @MethodSource("purchasedLottoTestData")
    void calculateProfitRate(PurchasedLotto purchasedLotto) {
        double calculatedProfitRate = purchasedLotto.calculateProfitRate(winningLotto);
        assertThat(calculatedProfitRate).isEqualTo(62.5);
    }

    static List<Arguments> purchasedLottoTestData() {
        return List.of(Arguments.of(new PurchasedLotto(List.of(
            new Lotto(List.of(8, 21, 23, 41, 42, 43)),
            new Lotto(List.of(3, 5, 11, 16, 32, 38)),
            new Lotto(List.of(7, 11, 16, 35, 36, 44)),
            new Lotto(List.of(1, 8, 11, 31, 41, 42)),
            new Lotto(List.of(13, 14, 16, 38, 42, 45)),
            new Lotto(List.of(7, 11, 30, 40, 42, 43)),
            new Lotto(List.of(2, 13, 22, 32, 38, 45)),
            new Lotto(List.of(1, 3, 5, 14, 22, 45))
            ))
        ));
    }
}