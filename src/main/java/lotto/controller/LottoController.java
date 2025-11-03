package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.dto.LottoResponse;
import lotto.dto.LottoResult;
import lotto.service.LottoService;
import lotto.util.ParseUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void lottoStart(InputView inputView) {
        //input
        String price = inputView.getBuyPrice();

        //processing
        int processedPrice = ParseUtil.parseInt(price);

        //call service
        List<Lotto> boughtLotto = lottoService.buyLotto(processedPrice);

        //output
        OutputView.printBoughtCount(boughtLotto.size());
        for (Lotto lotto : boughtLotto) {
            LottoResponse lottoResponse = new LottoResponse(lotto);

            OutputView.printMyLotto(lottoResponse);
        }

        //input
        String winNumber = inputView.getWinNumber();
        String bonus = inputView.getBonusNumber();

        //processing
        List<Integer> processedWinNumber = Arrays.stream(winNumber.split(","))
                .map(ParseUtil::parseInt)
                .toList();
        int processedBonus = ParseUtil.parseInt(bonus);

        //call service
        LottoResult lottoResult = lottoService.drawLottery(processedWinNumber, processedBonus, boughtLotto);

        //output
        OutputView.printResultHeader();
        Map<LottoRank, Integer> winningCount = lottoResult.getWinningCount();

        LottoRank[] ranks = LottoRank.values();
        float totalReward = 0;
        for (int i = ranks.length - 1; i >= 0; i--) {
            LottoRank rank = ranks[i];
            if (rank == LottoRank.NONE) continue; // NONE 제외

            int count = winningCount.getOrDefault(rank, 0);

            totalReward += rank.getReward() * count;
            OutputView.printResult(
                    rank.getMatchCount(),
                    rank.isMatchBonus(),
                    rank.getReward(),
                    count
            );
        }
        float rateOfReturn = totalReward / (float)processedPrice;

        OutputView.printRateOfReturn(rateOfReturn);
    }
}
