package lotto;

import java.util.List;
import lotto.error.exception.DuplicateNumberException;
import lotto.error.exception.NumberRangeException;
import lotto.error.exception.NumbersCountException;

public class Lotto {

    public static final int NUMBERS_COUNT = 6;
    public static final int NUMBER_MIN = 1;
    public static final int NUMBER_MAX = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_COUNT) {
            throw new NumbersCountException();
        }
        numbers.forEach(Lotto::validateRange);
        validateDuplicate(numbers);
    }

    private static void validateRange(int number) {
        if (number < NUMBER_MIN || number > NUMBER_MAX) {
            throw new NumberRangeException();
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        long distinctSize = numbers.stream().distinct().count();
        int size = numbers.size();
        if (distinctSize != size) {
            throw new DuplicateNumberException();
        }
    }
}
