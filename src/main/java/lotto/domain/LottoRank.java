package lotto.domain;

public enum LottoRank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int reward;

    LottoRank(int matchCount, boolean matchBonus, int reward) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public static LottoRank of(int matchCount, boolean bonus) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && bonus) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return NONE;
    }
}