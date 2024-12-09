package lotto.error.exception;

import lotto.error.ErrorType;
import lotto.error.LottoException;

public class NumbersCountException extends LottoException {
    public NumbersCountException() {
        super(ErrorType.NUMBERS_COUNT);
    }
}
