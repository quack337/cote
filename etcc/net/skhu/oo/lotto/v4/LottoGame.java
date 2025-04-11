package etcc.net.skhu.oo.lotto.v4;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LottoGame {
    static final int LOTTO_TICKET_PRICE = 1000;
    static final String MONEY_PROMPT = "구입금액을 입력해 주세요";
    static final String TICKET_COUNT_FORMAT_STRING = "%d개를 구매했습니다.\n";
    static final String WINNING_NUMBER_PROMPT = "지난 주 당첨 번호를 입력해주세요.";
    static final String BONUS_NO_PROMPT = "보너스 볼을 입력해 주세요.";
    static final String EARNING_RATE_FORMAT_STRING = "총 수익률은 %.2f%%입니다.";
    static final String RESULT_TITLE = "당첨 통계\n---------";
    static final String DELIMITER_REGEX = "[ ,\r\n]+";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int purchaseAmount = inputPurchaseAmount(scanner);
            List<Lotto> lottoTickets = buyLottoTickets(purchaseAmount);
            print(System.out, lottoTickets);
            WinningLotto winningLotto = inputWinningLotto(scanner, System.out);
            Map<Rank, Integer> winningTicketCount = winningLotto.match(lottoTickets);
            print(System.out, winningTicketCount);
            int prizeAmount = getPrizeAmount(winningTicketCount);
            printEarningRate(System.out, purchaseAmount, prizeAmount);
        }
    }

    private static int inputPurchaseAmount(Scanner scanner) {
        System.out.println(MONEY_PROMPT);
        return scanner.nextInt();
    }

    private static List<Lotto> buyLottoTickets(int purchaseAmount) {
        int ticketCount = purchaseAmount / LOTTO_TICKET_PRICE;
        return LottoFactory.createLottoTickets(ticketCount);
    }

    private static void print(PrintStream out, List<Lotto> lottoTickets) {
        out.printf(TICKET_COUNT_FORMAT_STRING, lottoTickets.size());
        for (Lotto ticket : lottoTickets)
            out.println(ticket);
    }

    private static void print(PrintStream out, Map<Rank, Integer> winningTicketCount) {
        out.println(RESULT_TITLE);
        for (Rank rank : Rank.values()) {
            Integer count = winningTicketCount.get(rank);
            out.printf("%s- %d개\n", rank, (count == null) ? 0 : count);
        }
    }

    private static WinningLotto inputWinningLotto(Scanner scanner, PrintStream out) {
        out.println(WINNING_NUMBER_PROMPT);
        List<Integer> numbers = new ArrayList<>();
        scanner.useDelimiter(DELIMITER_REGEX);
        for (int i = 0; i < LottoFactory.NUMBER_COUNT; ++i)
            numbers.add(scanner.nextInt());
        out.println(BONUS_NO_PROMPT);
        int bonusNo = scanner.nextInt();
        return new WinningLotto(new Lotto(numbers), bonusNo);
    }

    private static int getPrizeAmount(Map<Rank, Integer> winningTicketCount) {
        int amount = 0;
        for (Rank rank : winningTicketCount.keySet())
            amount += rank.getPrizeMoney() * winningTicketCount.get(rank);
        return amount;
    }

    private static void printEarningRate(PrintStream out, int purchaseAmount, int prizeAmount) {
        double earningRate = prizeAmount * 100.0 / purchaseAmount;
        out.printf(EARNING_RATE_FORMAT_STRING, earningRate);
    }
}