package lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

public class PurchasedLotto {

    private final List<Lotto> lottos;

    public PurchasedLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int count() {
        return lottos.size();
    }

    public Map<Rank, Long> countRanks(WinningLotto winningLotto) {
        return lottos.stream()
            .map(winningLotto::rank)
            .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    public double calculateProfitRate(WinningLotto winningLotto) {
        Map<Rank, Long> countedRanks = countRanks(winningLotto);
        long totalPrize = countedRanks.entrySet()
            .stream()
            .mapToLong(entry -> entry.getKey().prize() * entry.getValue())
            .sum();
        long principle = (long) count() * LottoShop.PRICE;

        return (double) totalPrize / principle * 100.0;
    }

    @Override
    public String toString() {
        return lottos.stream()
            .map(Lotto::toString)
            .collect(Collectors.joining("\n"));
    }
}
