package etcc.net.skhu.oo.lotto.v9;
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

    public Rank match(Lotto userLotto) {
        int matchCount = this.lotto.getMatchCount(userLotto);
        boolean bonusMatch = userLotto.contains(bonusNo);
        return Rank.getRank(matchCount, bonusMatch);
    }

    public Map<Rank, Integer> match(List<Lotto> tickets) {
        Map<Rank, Integer> winningTicketCount = new HashMap<Rank, Integer>();
        for (Lotto lottoTicket : tickets) {
            Rank rank = this.match(lottoTicket);
            if (rank == null) continue;
            Integer count = winningTicketCount.get(rank);
            winningTicketCount.put(rank, (count == null) ? 1 : count + 1);
        }
        return winningTicketCount;
    }
}