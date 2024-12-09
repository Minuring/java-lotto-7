package lotto.error;

public class LottoException extends IllegalArgumentException {

    private final ErrorType errorType;

    public LottoException(ErrorType errorType) {
        super(errorType.toString());
        this.errorType = errorType;
    }

    public ErrorType getErrorType() {
        return errorType;
    }
}
