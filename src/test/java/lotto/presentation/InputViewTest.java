package lotto.presentation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest extends IOTest {

    @DisplayName("입력 요구 메세지 출력")
    @Test
    void displayHeader() {
        systemIn("1000"); //입력 무한대기 방지를 위한 dummy 값
        InputView.readBuyAmount();
        assertThat(systemOutput()).contains("구입금액을 입력해 주세요.");
    }

    @DisplayName("로또 구입금액 읽기")
    @Test
    void readBuyAmount() {
        systemIn("2000");
        long buyAmount = InputView.readBuyAmount();
        assertThat(buyAmount).isEqualTo(2000L);
    }
}