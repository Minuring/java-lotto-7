package lotto.error.exception;

import lotto.error.ErrorType;
import lotto.error.LottoException;

public class NumberRangeException extends LottoException {

    public NumberRangeException() {
        super(ErrorType.NUMBER_RANGE);
    }
}
