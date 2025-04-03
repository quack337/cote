package net.skhu.oo.lotto.v4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto lottoTicket) {
        int matchCount = lottoTicket.getMatchingNumberCount(this.lotto);
        boolean bonusMatch = lottoTicket.contains(this.bonusNo);
        return Rank.getRank(matchCount, bonusMatch);
    }

    public Map<Rank, Integer> match(List<Lotto> lottoTickets) {
        Map<Rank, Integer> winningTicketCount = new HashMap<>();
        for (Lotto lottoTicket : lottoTickets) {
            Rank rank = this.match(lottoTicket);
            if (rank == null) continue;  // 당첨 실패
            Integer count = winningTicketCount.get(rank); // 당첨 복권 수 증가
            winningTicketCount.put(rank, (count == null) ? 1 : count + 1);
        }
        return winningTicketCount;
    }
}