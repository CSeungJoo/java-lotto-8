package lotto.dto;

import lotto.domain.Lotto;
import lotto.vo.WinningLotto;

import java.util.List;

public class LottoResponse {
    private List<Integer> lottoNumber;

    public LottoResponse(Lotto lotto) {
        this.lottoNumber = lotto.getNumbers();
    }

    public LottoResponse(WinningLotto winningLotto) {
        this.lottoNumber = winningLotto.getNumbers();
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }
}
