package lotto.error;

public class LottoException extends IllegalArgumentException {

    public LottoException() {
    }

    public LottoException(ErrorType errorType) {
        super(errorType.toString());
    }
}
