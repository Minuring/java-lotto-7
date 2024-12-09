package lotto.error.exception;

import lotto.error.ErrorType;
import lotto.error.LottoException;

public class InvalidBuyAmountException extends LottoException {

    public InvalidBuyAmountException() {
        super(ErrorType.INVALID_BUY_AMOUNT);
    }
}
