package lotto;

import lotto.controller.LottoController;
import lotto.infra.LottoNumberGeneratorImpl;
import lotto.service.LottoService;
import lotto.view.InputView;

public class Application {

    private static void run() {
        LottoNumberGeneratorImpl lottoNumberGenerator = LottoNumberGeneratorImpl.ofDefault();
        LottoService lottoService = new LottoService(lottoNumberGenerator);
        LottoController lottoController = new LottoController(lottoService);

        try(InputView inputView = new InputView()) {
            lottoController.lottoStart(inputView);
        }
    }

    public static void main(String[] args) {
        run();
    }
}
