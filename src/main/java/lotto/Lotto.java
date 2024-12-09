package lotto;

import static lotto.LottoValidator.validateCount;
import static lotto.LottoValidator.validateDuplicate;

import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final int NUMBERS_COUNT = 6;
    public static final int NUMBER_MIN = 1;
    public static final int NUMBER_MAX = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        numbers.forEach(LottoValidator::validateRange);
        validateDuplicate(numbers);
    }
}
