package lotto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class PurchasedLotto {

    private final List<Lotto> lottos;

    public PurchasedLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int count() {
        return lottos.size();
    }

    @Override
    public String toString() {
        return lottos.stream()
            .map(Lotto::toString)
            .collect(Collectors.joining("\n"));
    }
}
