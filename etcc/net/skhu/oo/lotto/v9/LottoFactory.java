package etcc.net.skhu.oo.lotto.v9;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoFactory {
    public static final int TICKET_PRICE = 1000;
    public static final int NUMBER_COUNT = 6;
    public static final int NUMBER_MAX = 45;

    private static Random random = new Random();

    private static Lotto createLottoTicket() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUMBER_COUNT) {
            int i = random.nextInt(NUMBER_MAX) + 1;
            if (numbers.contains(i)) continue;
            numbers.add(i);
        }
        return new Lotto(numbers);
    }

    public static List<Lotto> createLottoTickets(int ticketCount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; ++i)
            tickets.add(LottoFactory.createLottoTicket());
        return tickets;
    }
}