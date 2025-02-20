package net.skhu.oo.lotto.v9;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

    public int getMatchCount(Lotto lotto) {
        int count = 0;
        for (int n: this.numbers)
            count += lotto.contains(n) ? 1 : 0;
        return count;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
