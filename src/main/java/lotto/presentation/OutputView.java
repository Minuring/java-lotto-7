package lotto.presentation;

import java.util.Map;
import java.util.Map.Entry;
import lotto.PurchasedLotto;
import lotto.domain.Rank;
import lotto.error.ErrorType;

public class OutputView {

    public static void printError(ErrorType error) {
        System.out.println(error.toString());
    }

    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printPurchaseInfo(PurchasedLotto purchasedLotto) {
        System.out.println(purchasedLotto.count() + "개를 구매했습니다.");
        System.out.println(purchasedLotto);
        System.out.println();
    }

    public static void printStatistics(Map<Rank, Long> countedRanks, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Entry<Rank, Long> entry : countedRanks.entrySet()) {
            if (entry.getKey() != Rank.NONE) {
                printRankEntries(entry);
            }
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }

    private static void printRankEntries(Entry<Rank, Long> entry) {
        Rank rank = entry.getKey();
        Long count = entry.getValue();
        String format = String.format(
            "%d개 일치 (%,d원) - %d개",
            rank.required(), rank.prize(), count);
        System.out.println(format);
    }
}
