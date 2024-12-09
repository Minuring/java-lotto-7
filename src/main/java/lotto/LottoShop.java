package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.error.exception.InvalidBuyAmountException;

public class LottoShop {

    public static final int PRICE = 1000;

    public static PurchasedLotto purchase(int buyAmount) {
        validateBuyAmount(buyAmount);
        int count = buyAmount / PRICE;
        List<Lotto> lottos = generateLottos(count);
        return new PurchasedLotto(lottos);
    }

    private static List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        while(count-- > 0) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static void validateBuyAmount(int buyAmount) {
        int count = buyAmount / PRICE;
        if (count < 1 || buyAmount % PRICE != 0) {
            throw new InvalidBuyAmountException();
        }
    }
}
