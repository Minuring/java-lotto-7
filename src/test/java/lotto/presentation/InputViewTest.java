package lotto.presentation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest extends IOTest {

    @DisplayName("로또 구입금액 입력 요구 메세지 출력")
    @Test
    void displayBuyAmountHeader() {
        systemIn("1000"); //입력 무한대기 방지를 위한 dummy 값
        InputView.readBuyAmount();
        assertThat(systemOutput()).contains("구입금액을 입력해 주세요.");
    }

    @DisplayName("당첨번호 입력 요구 메세지 출력")
    @Test
    void displayWinningNumbersHeader() {
        systemIn("1,2,3,4,5,6"); //입력 무한대기 방지를 위한 dummy 값
        InputView.readWinningLotto();
        assertThat(systemOutput()).contains("당첨 번호를 입력해 주세요.");
    }

    @DisplayName("보너스 번호 입력 요구 메세지 출력")
    @Test
    void displayBonusNumbersHeader() {
        systemIn("7"); //입력 무한대기 방지를 위한 dummy 값
        InputView.readBonusNumber();
        assertThat(systemOutput()).contains("보너스 번호를 입력해 주세요.");
    }

    @DisplayName("로또 구입금액 읽기")
    @Test
    void readBuyAmount() {
        systemIn("2000");
        long buyAmount = InputView.readBuyAmount();
        assertThat(buyAmount).isEqualTo(2000L);
    }

    @DisplayName("로또 당첨번호 읽기")
    @Test
    void readWinningLotto() {
        systemIn("1,2,3,4,5,6");
        Lotto winningLotto = InputView.readWinningLotto();
        assertThat(winningLotto.getNumbers())
            .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("로또 보너스 번호 읽기")
    @Test
    void readBonusNumber() {
        systemIn("7");
        int bonusNumber = InputView.readBonusNumber();
        assertThat(bonusNumber).isEqualTo(7);
    }
}