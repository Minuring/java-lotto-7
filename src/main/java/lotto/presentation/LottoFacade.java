package lotto.presentation;

import java.util.Map;
import java.util.function.Supplier;
import lotto.LottoShop;
import lotto.PurchasedLotto;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.error.ErrorType;
import lotto.error.LottoException;

public class LottoFacade {

    public static void run() {
        PurchasedLotto purchasedLotto = purchaseLottos();
        OutputView.printPurchaseInfo(purchasedLotto);

        WinningLotto winningLotto = determineWinningLotto();

        Map<Rank, Long> countedRanks = purchasedLotto.countRanks(winningLotto);
        double profitRate = purchasedLotto.calculateProfitRate(winningLotto);
        OutputView.printStatistics(countedRanks, profitRate);
    }

    private static WinningLotto determineWinningLotto() {
        return executeWithHandlingException(() -> {
            Lotto winningLotto = InputView.readWinningLotto();
            int bonusNumber = executeWithHandlingException(InputView::readBonusNumber);
            return new WinningLotto(winningLotto, bonusNumber);
        });
    }

    private static PurchasedLotto purchaseLottos() {
        return executeWithHandlingException(() -> {
            long buyAmount = InputView.readBuyAmount();
            return LottoShop.purchase(buyAmount);
        });
    }

    public static <T> T executeWithHandlingException(Supplier<T> readMethod) {
        try {
            return readMethod.get();
        } catch (NumberFormatException e) {
            OutputView.printError(ErrorType.NUMBER_FORMAT);
        } catch (LottoException e) {
            OutputView.printError(e.getErrorType());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
        }

        return executeWithHandlingException(readMethod);
    }
}
