package lotto.presentation;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;

public class InputView {

    public static long readBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Long.parseLong(Console.readLine());
    }

    public static Lotto readWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        List<Integer> numbers = toListByDelimiter(input, ",");
        return new Lotto(numbers);
    }

    public static int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    private static List<Integer> toListByDelimiter(String input, String delimiter) {
        String[] rawNumbers = input.split(delimiter);
        return Arrays.stream(rawNumbers)
            .map(Integer::parseInt)
            .toList();
    }
}
