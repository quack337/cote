package net.skhu.oo.lotto.v4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoFactory {

    public static final int NUMBER_MAX = 45;
    public static final int NUMBER_COUNT = 6;

    public static List<Lotto> createLottoTickets(int ticketCount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < ticketCount; ++i) {
            Lotto lotto = createLottoTicket(random);
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }

    public static Lotto createLottoTicket(Random random) {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUMBER_COUNT) {
            int n = random.nextInt(NUMBER_MAX) + 1;
            if (numbers.contains(n)) continue;
            numbers.add(n);
        }
        return new Lotto(numbers);
    }
}
