package lotto.vo;

import lotto.domain.Lotto;

import java.util.List;
import java.util.Objects;

public final class WinningLotto {

    private Integer bouns;
    private final List<Integer> numbers;

    public WinningLotto(Lotto lotto, Integer bouns) {
        this.numbers = lotto.getNumbers();
        this.bouns = bouns;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getBouns() {
        return bouns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinningLotto)) return false;
        WinningLotto that = (WinningLotto) o;
        return numbers.equals(that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}