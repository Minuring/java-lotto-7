package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    NONE(0, 0);

    private final int prize;
    private final int required;

    Rank(int prize, int required) {
        this.prize = prize;
        this.required = required;
    }

    static Rank of(int matchedCount, boolean matchesBonus) {
        if (matchedCount == SECOND.required) {
            return determineSecondOrThird(matchesBonus);
        }

        return Arrays.stream(Rank.values())
            .filter(rank -> rank.required == matchedCount)
            .findAny()
            .orElse(NONE);
    }

    private static Rank determineSecondOrThird(boolean matchesBonus) {
        if (matchesBonus) {
            return SECOND;
        }
        return THIRD;
    }
}
