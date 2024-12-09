package lotto.presentation;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoFacadeTest extends IOTest{

    @Test
    void test() {
        systemIn("8000");
        systemIn("1,2,3,4,5,6");
        systemIn("7");
        LottoFacade.run();

        super.cleanUp();
        System.out.println(systemOutput());
    }

}