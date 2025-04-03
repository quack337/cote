package net.skhu.oo.lotto.v9;

public enum Rank {
    FIRST(2000000000, 6, false),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5, false),
    FOURTH(50000, 4, false),
    FIFTH(5000, 3, false);

    private int prizeMoney;
    private int matchCount;
    private boolean bonusMatch;

    Rank(int prizeMoney, int matchCount, boolean bonusMatch) {
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Rank getRank(int matchCount, boolean bonusMatch) {
        for (Rank rank : Rank.values())
            if (rank.matchCount == matchCount && rank.bonusMatch == bonusMatch)
                return rank;
        return null;
    }

    @Override
    public String toString() {
        String formatString = bonusMatch ? "%d개 일치, 보너스 볼 일치(%d원)" : "%d개 일치 (%d원)";
        return String.format(formatString, matchCount, prizeMoney);
    }
}