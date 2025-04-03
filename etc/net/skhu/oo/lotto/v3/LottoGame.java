package net.skhu.oo.lotto.v3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LottoGame {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            // 로또 구입 금액 입력
            System.out.println("구입금액을 입력해 주세요");
            int purchaseAmount = scanner.nextInt();

            // 구입 금액만큼 Lotto 객체 목록 생성
            int ticketCount = purchaseAmount / 1000;
            List<Lotto> lottoTickets = LottoFactory.createLottoTickets(ticketCount);

            // 생성된 Lotto 객체 목록 출력
            System.out.printf("%d개를 구매했습니다.\n", lottoTickets.size());
            for (Lotto ticket : lottoTickets)
                System.out.println(ticket.getNumbers());

            // 당첨 번호 입력 받아서, WinningLotto 객체 생성
            System.out.println("지난 주 당첨 번호를 입력해주세요.");
            List<Integer> numbers = new ArrayList<>();
            scanner.useDelimiter("[ ,\r\n]+");
            for (int i = 0; i < 6; ++i)
                numbers.add(scanner.nextInt());
            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNo = scanner.nextInt();
            WinningLotto winningLotto = new WinningLotto(new Lotto(numbers), bonusNo);

            // 담청 로또 복권 수 세기
            Map<Rank, Integer> winningTicketCount = new HashMap<>();
            for (Lotto lottoTicket : lottoTickets) {
                int matchCount = 0;
                // 일치하는 수 세기
                for (int n : winningLotto.getLotto().getNumbers())
                    matchCount += lottoTicket.getNumbers().contains(n) ? 1 : 0;
                // 보너스 번호 일치하는가?
                boolean bonusMatch = lottoTicket.getNumbers().contains(winningLotto.getBonusNo());

                Rank rank = Rank.getRank(matchCount, bonusMatch);
                if (rank == null) continue;  // 당첨 실패
                // 당첨 복권 수 증가
                Integer count = winningTicketCount.get(rank);
                winningTicketCount.put(rank, (count == null) ? 1 : count + 1);
            }

            // 당첨 로또 복권 수 출력
            System.out.println("당첨 통계\n---------");
            for (Rank rank : Rank.values()) {
                Integer count = winningTicketCount.get(rank);
                System.out.printf("%s- %d개\n", rank, (count == null) ? 0 : count);
            }

            // 당첨 금액 합계
            int amount = 0;
            for (Rank rank : winningTicketCount.keySet())
                amount += rank.getPrizeMoney() * winningTicketCount.get(rank);

            // 수익률 출력
            double earningRate = amount * 100.0 / purchaseAmount;
            System.out.printf("총 수익률은 %.2f%%입니다.\n", earningRate);
        }
    }
}