package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoRank;
import lotto.dto.LottoResult;
import lotto.vo.WinningLotto;
import lotto.infra.LottoNumberGeneratorImpl;

import java.util.*;

public class LottoService {

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoService(LottoNumberGeneratorImpl lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> buyLotto(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1000원 단위로 구매할 수 있습니다.");
        }

        int purchaseCount = price / 1000;

        List<Lotto> boughtLotto = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = Lotto.from(lottoNumberGenerator);

            boughtLotto.add(lotto);
        }

        return boughtLotto;
    }

    public LottoResult drawLottery(List<Integer> lottoNumber, Integer bonusNumber, List<Lotto> boughtLottos) {
        Lotto lotto = new Lotto(lottoNumber);

        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        Map<LottoRank, Integer> winningCount = new HashMap<>();
        for (Lotto boughtLotto : boughtLottos) {
            Map<Integer, Integer> countMap = new HashMap<>();
            lottoNumber.forEach(i -> countMap.put(i, countMap.getOrDefault(i, 0) + 1));

            int commonCount = boughtLotto.getNumbers().stream()
                    .mapToInt(elem -> {
                        Integer remaining = countMap.getOrDefault(elem, 0);
                        if (remaining > 0) {
                            countMap.put(elem, remaining - 1);
                            return 1;
                        }
                        return 0;
                    })
                    .sum();
            boolean bonus = boughtLotto.getNumbers().contains(bonusNumber);
            LottoRank lottoRank = LottoRank.of(commonCount, bonus);

            winningCount.merge(lottoRank, 1, Integer::sum);
        }

        LottoResult lottoResult = new LottoResult(winningCount);

        return lottoResult;
    }

}
