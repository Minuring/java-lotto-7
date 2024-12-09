package lotto;

import static lotto.LottoValidator.validateRange;

import java.util.ArrayList;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, Integer bonusNumber) {
        validateDuplicate(lotto, bonusNumber);
        validateRange(bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank rank(Lotto lotto) {
        int matchedCount = this.lotto.countMatches(lotto);
        boolean matchesBonus = lotto.containsNumber(bonusNumber);
        return Rank.of(matchedCount, matchesBonus);
    }

    private static void validateDuplicate(Lotto lotto, Integer bonusNumber) {
        ArrayList<Integer> allNumbers = new ArrayList<>(lotto.getNumbers());
        allNumbers.add(bonusNumber);
        LottoValidator.validateDuplicate(allNumbers);
    }
}
