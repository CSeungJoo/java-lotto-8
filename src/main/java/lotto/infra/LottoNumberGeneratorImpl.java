package lotto.infra;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.LottoNumberGenerator;

import java.util.*;

public class LottoNumberGeneratorImpl implements LottoNumberGenerator {

    private static final int MINIMUM_LOTTO_VALUE = 1;
    private static final int MAXIMUM_LOTTO_VALUE = 45;
    private static final int LOTTO_LENGTH = 6;

    private int minimumValue;
    private int maximumValue;
    private int lottoLength;

    private LottoNumberGeneratorImpl(int minimumValue, int maximumValue, int lottoLength) {
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
        this.lottoLength = lottoLength;
    }

    public static LottoNumberGeneratorImpl ofDefault() {
        LottoNumberGeneratorImpl gameRandom = new LottoNumberGeneratorImpl(MINIMUM_LOTTO_VALUE, MAXIMUM_LOTTO_VALUE, LOTTO_LENGTH);

        return gameRandom;
    }

    public static LottoNumberGeneratorImpl of(int minimumValue, int maximumValue, int lottoLength) {
        LottoNumberGeneratorImpl gameRandom = new LottoNumberGeneratorImpl(minimumValue, maximumValue, lottoLength);

        return gameRandom;
    }

    @Override
    public List<Integer> pickNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(minimumValue, maximumValue, lottoLength);

        return lottoNumber;
    }
}