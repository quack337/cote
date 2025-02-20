package net.skhu.oo.lotto.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LottoGame {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            // 로또 구입 금액 입력
            System.out.println("구입금액을 입력해 주세요");
            int purchaseAmount = scanner.nextInt();

            // 구입 금액만큼 Lotto 객체 목록 생성
            int ticketCount = purchaseAmount / 1000;
            List<Lotto> lottoTickets = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < ticketCount; ++i) {
                List<Integer> numbers = new ArrayList<>();
                while (numbers.size() < 6) {
                    int n = random.nextInt(45) + 1;
                    if (numbers.contains(n)) continue;
                    numbers.add(n);
                }
                lottoTickets.add(new Lotto(numbers));
            }

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
            int[] winningTicketCount = new int[5];
            for (Lotto lottoTicket : lottoTickets) {
                int matchCount = 0;
                // 일치하는 수 세기
                for (int n : winningLotto.getLotto().getNumbers())
                    matchCount += lottoTicket.getNumbers().contains(n) ? 1 : 0;
                // 보너스 번호 일치하는가?
                boolean bonusMatch = lottoTicket.getNumbers().contains(winningLotto.getBonusNo());

                int rank = -1;
                switch (matchCount) {
                case 6: rank = 0; break; // 숫자 6개 일치 0등
                case 5: rank = bonusMatch ? 1 : 2; break; // 숫자 5개 일치, 보너스 번호까지 일치하면
                                                          // 1등 아니면 2등
                case 4: rank = 3; break; // 숫자 4개 일치 3등
                case 3: rank = 4; break; // 숫자 3개 일치 4등
                }
                if (rank == -1) continue;    // 당첨 실패
                ++winningTicketCount[rank];  // 당첨 복권 수 증가
            }

            // 당첨 로또 복권 수 출력
            System.out.println("당첨 통계\n---------");
            System.out.printf("6개 일치 (2000000000원)- %d개\n", winningTicketCount[0]);
            System.out.printf("5개 일치, 보너스 볼 일치 (30000000원)- %d개\n", winningTicketCount[1]);
            System.out.printf("5개 일치 (1500000원)- %d개\n", winningTicketCount[2]);
            System.out.printf("4개 일치 (50000원)- %d개\n", winningTicketCount[3]);
            System.out.printf("3개 일치 (5000원)- %d개\n", winningTicketCount[4]);

            // 당첨 금액 합계
            final int[] prizeMoney = {2000000000, 30000000, 1500000, 50000, 5000};
            int amount = 0; // 합계
            for (int rank = 0; rank < 5; ++rank)
                amount += prizeMoney[rank] * winningTicketCount[rank];

            // 수익률 출력
            double earningRate = amount * 100.0 / purchaseAmount;
            System.out.printf("총 수익률은 %.2f%%입니다.\n", earningRate);
        }
    }
}
