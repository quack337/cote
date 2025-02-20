package net.skhu.oo.lotto.v2;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNo() {
        return bonusNo;
    }
}
