package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.error.exception.InvalidBuyAmountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoShopTest {

    @DisplayName("로또 가격에 따라 알맞은 수량의 로또를 발행한다.")
    @Test
    void purchaseLottos() {
        PurchasedLotto purchasedLotto = LottoShop.purchase(5000);
        assertThat(purchasedLotto.count()).isEqualTo(5);
    }

    @DisplayName("구입 금액이 유효하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1000, 999, 1500, 9999})
    void purchaseLottosInvalidBuyAmount(int buyAmount) {
        assertThatThrownBy(() -> LottoShop.purchase(buyAmount))
            .isInstanceOf(InvalidBuyAmountException.class);
    }
}