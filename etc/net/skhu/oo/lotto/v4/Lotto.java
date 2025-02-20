package net.skhu.oo.lotto.v4;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int getMatchingNumberCount(Lotto lottoTicket) {
        int matchCount = 0;
        for (int n : this.numbers)
            matchCount += lottoTicket.contains(n) ? 1 : 0;
        return matchCount;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}