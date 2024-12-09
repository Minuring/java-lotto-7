package lotto.error;

public enum ErrorType {
    NUMBERS_COUNT("로또 번호는 6개여야 합니다."),
    NUMBER_RANGE("로또 번호의 숫자 범위는 1~45 입니다."),
    NUMBER_DUPLICATED("로또 번호는 중복될 수 없습니다."),

    INVALID_BUY_AMOUNT("로또 구입은 1000원 단위로만 가능합니다."),
    NUMBER_FORMAT("반드시 숫자여야 합니다.")
    ;

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String toString() {
        return PREFIX + message;
    }
}
