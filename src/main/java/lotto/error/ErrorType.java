package lotto.error;

public enum ErrorType {
    NUMBERS_COUNT("로또 번호는 6개여야 합니다."),
    NUMBER_RANGE("로또 번호의 숫자 범위는 1~45 입니다."),
    NUMBER_DUPLICATED("로또 번호는 중복될 수 없습니다."),
    ;

    private final String message;
    ErrorType(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
