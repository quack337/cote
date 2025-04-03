package net.skhu.oo.lotto.v9;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LottoGame {

    static final String MONEY_PROMPT = "구입금액을 입력해 주세요";
    static final String TICKET_COUNT_FORMAT_STRING = "%d개를 구매했습니다.\n";
    static final String WINNING_NUMBER_PROMPT = "지난 주 당첨 번호를 입력해주세요.";
    static final String BONUS_NO_PROMPT = "보너스 볼을 입력해 주세요.";
    static final String EARNING_RATE_FORMAT_STRING = "총 수익률은 %.2f%%입니다.";
    static final String RESULT_TITLE = "당첨 통계\n---------";
    static final String DELIMITER_REGEX = "[ ,\r\n]+";

    private InputStream in;
    private PrintStream out;

    public LottoGame(InputStream in, PrintStream out) {
        this.in = in;
        this.out = out;
    }

    private int inputPurchaseAmount(Scanner scanner) {
        out.println(MONEY_PROMPT);
        return scanner.nextInt();
    }

    private List<Lotto> buyLottoTickets(int money) {
        int ticketCount = money / LottoFactory.TICKET_PRICE;
        return LottoFactory.createLottoTickets(ticketCount);
    }

    private void print(PrintStream out, List<Lotto> tickets) {
        out.printf(TICKET_COUNT_FORMAT_STRING, tickets.size());
        for (Lotto ticket : tickets)
            out.println(ticket);
    }

    private WinningLotto inputWinningLotto(Scanner scanner) {
        out.println(WINNING_NUMBER_PROMPT);
        List<Integer> numbers = new ArrayList<>();
        scanner.useDelimiter(DELIMITER_REGEX);
        for (int i = 0; i < LottoFactory.NUMBER_COUNT; ++i)
            numbers.add(scanner.nextInt());
        out.println(BONUS_NO_PROMPT);
        int bonusNo = scanner.nextInt();
        return new WinningLotto(new Lotto(numbers), bonusNo);
    }

    private void print(PrintStream out, Map<Rank, Integer> winningTicketCount) {
        out.println(RESULT_TITLE);
        for (Rank rank : Rank.values()) {
            Integer count = winningTicketCount.get(rank);
            out.printf("%s- %d개\n", rank, (count == null) ? 0 : count);
        }
    }

    private int getPrizeAmount(Map<Rank, Integer> winningTicketCount) {
        int prizeAmount = 0;
        for (Rank rank : winningTicketCount.keySet()) {
            int ticketCount = winningTicketCount.get(rank);
            prizeAmount += rank.getPrizeMoney() * ticketCount;
        }
        return prizeAmount;
    }

    private void printEraningRate(PrintStream out, int prizeAmount, int purchaseAmount) {
        double earningRate = prizeAmount * 100.0 / purchaseAmount;
        out.printf(EARNING_RATE_FORMAT_STRING, earningRate);
    }

    public void run() {
        try (Scanner scanner = new Scanner(in)) {
            int purchaseAmount = inputPurchaseAmount(scanner);
            List<Lotto> lottoTickets = buyLottoTickets(purchaseAmount);
            print(out, lottoTickets);
            WinningLotto winningLotto = inputWinningLotto(scanner);
            Map<Rank, Integer> winningTicketCount = winningLotto.match(lottoTickets);
            print(out, winningTicketCount);
            int prizeAmount = getPrizeAmount(winningTicketCount);
            printEraningRate(out, prizeAmount, purchaseAmount);
        }
    }
}