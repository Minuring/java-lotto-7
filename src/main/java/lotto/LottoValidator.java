package lotto;

import static lotto.domain.Lotto.NUMBERS_COUNT;
import static lotto.domain.Lotto.NUMBER_MAX;
import static lotto.domain.Lotto.NUMBER_MIN;

import java.util.List;
import lotto.error.exception.DuplicateNumberException;
import lotto.error.exception.NumberRangeException;
import lotto.error.exception.NumbersCountException;

public class LottoValidator {

    public static void validateCount(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_COUNT) {
            throw new NumbersCountException();
        }
    }

    public static void validateRange(int number) {
        if (number < NUMBER_MIN || number > NUMBER_MAX) {
            throw new NumberRangeException();
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        long distinctSize = numbers.stream().distinct().count();
        int size = numbers.size();
        if (distinctSize != size) {
            throw new DuplicateNumberException();
        }
    }

}
