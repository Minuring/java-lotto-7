package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.error.exception.DuplicateNumberException;
import lotto.error.exception.NumberRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {

    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    WinningLotto winningLotto = new WinningLotto(lotto, 7);

    @DisplayName("로또 당첨 순위 결정 테스트")
    @ParameterizedTest
    @MethodSource("lottos")
    void rankLotto(Lotto lotto, Rank expectedRank) {
        Rank rank = winningLotto.rank(lotto);
        assertThat(rank).isEqualTo(expectedRank);
    }

    static List<Arguments> lottos() {
        return List.of(
            Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), Rank.FIRST),
            Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), Rank.SECOND),
            Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 45)), Rank.THIRD),
            Arguments.of(new Lotto(List.of(1, 2, 3, 4, 44, 45)), Rank.FOURTH),
            Arguments.of(new Lotto(List.of(1, 2, 3, 43, 44, 45)), Rank.FIFTH),
            Arguments.of(new Lotto(List.of(1, 2, 7, 43, 44, 45)), Rank.NONE)
        );
    }

    @DisplayName("보너스 번호가 로또 숫자 범위 내에 없으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void bonusNumberNotInRange(int invalidBonusNumber) {
        assertThatThrownBy(() -> new WinningLotto(lotto, invalidBonusNumber))
            .isInstanceOf(NumberRangeException.class);
    }

    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void bonusNumberDuplicated() {
        assertThatThrownBy(() -> new WinningLotto(lotto, 2))
            .isInstanceOf(DuplicateNumberException.class);
    }
}