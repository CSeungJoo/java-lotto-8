package lotto.dto;

import lotto.domain.LottoRank;

import java.util.Collections;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> winningCount;

    public LottoResult(Map<LottoRank, Integer> winningCount) {
        this.winningCount = winningCount;
    }

    public Map<LottoRank, Integer> getWinningCount() {
        return Collections.unmodifiableMap(winningCount);
    }
}
