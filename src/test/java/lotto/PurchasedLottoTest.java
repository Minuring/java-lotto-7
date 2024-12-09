package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasedLottoTest {

    Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    Lotto lotto2 = new Lotto(List.of(12, 11, 10, 9, 8, 7));
    PurchasedLotto purchasedLotto = new PurchasedLotto(List.of(lotto1, lotto2));

    @DisplayName("발행한 로또의 수량을 알 수 있다.")
    @Test
    void countPurchasedLotto() {
        assertThat(purchasedLotto.count()).isEqualTo(2);
    }

    @DisplayName("toString은 발행한 로또의 번호를 오름차순으로 리턴한다.")
    @Test
    void toStringPurchasedLotto() {
        assertThat(purchasedLotto.toString())
            .contains("[1, 2, 3, 4, 5, 6]")
            .contains("[7, 8, 9, 10, 11, 12]");
    }
}