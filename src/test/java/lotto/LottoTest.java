package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.error.exception.DuplicateNumberException;
import lotto.error.exception.NumberRangeException;
import lotto.error.exception.NumbersCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("numbersThatSizeIsNotSix")
    void 로또_번호의_개수가_6개가_아니면_예외가_발생한다(List<Integer> numbersContainingDuplicated) {
        assertThatThrownBy(() -> new Lotto(numbersContainingDuplicated))
            .isInstanceOf(NumbersCountException.class);
    }

    static List<Arguments> numbersThatSizeIsNotSix() {
        return List.of(
            Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7)),
            Arguments.of(List.of(1, 2, 3, 4, 5))
        );
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(DuplicateNumberException.class);
    }

    @DisplayName("로또 번호의 숫자 범위안에 없으면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("numbersThatContainingNotInRange")
    void containingNotInRangeNumber(List<Integer> numbersContainingNotInRange) {
        assertThatThrownBy(() -> new Lotto(numbersContainingNotInRange))
            .isInstanceOf(NumberRangeException.class);
    }

    static List<Arguments> numbersThatContainingNotInRange() {
        return List.of(
            Arguments.of(List.of(0, 2, 3, 4, 5, 6)),
            Arguments.of(List.of(1, 2, 3, 4, 5, 46))
        );
    }
}
