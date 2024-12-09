package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.error.exception.DuplicateNumberException;
import lotto.error.exception.NumberRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {

    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

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