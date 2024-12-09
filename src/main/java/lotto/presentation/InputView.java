package lotto.presentation;

import camp.nextstep.edu.missionutils.Console;
import lotto.error.exception.InvalidBuyAmountException;

public class InputView {

    public static long readBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return toLong(Console.readLine());
    }

    private static long toLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new InvalidBuyAmountException();
        }
    }
}
