package lotto.error.exception;

import lotto.error.ErrorType;
import lotto.error.LottoException;

public class DuplicateNumberException extends LottoException {

    public DuplicateNumberException() {
      super(ErrorType.NUMBER_DUPLICATED);
    }
}
