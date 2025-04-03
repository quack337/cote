package programmers.e258707;

import java.util.HashSet;
import java.util.Set;

public class Main1 {

    static class Solution {
int[] cards;
int N;

boolean 카드제출(Set<Integer> cards) {
    for (int i : cards)
        if (cards.contains(N + 1 - i)) {
            cards.remove(i);
            cards.remove(N + 1 - i);
            return true;
        }
    return false;
}

int  완전탐색(Set<Integer> myCards, int coin, int top) {
    if (top == N) return 1;
    int card1 = cards[top], card2 = cards[top + 1];
    int r = 0;

    var myCards1 = new HashSet<>(myCards);
    if (카드제출(myCards1))
        r = Math.max(r, 완전탐색(myCards1, coin, top + 2));

    if (coin > 0) {
        var myCards2 = new HashSet<>(myCards);
        myCards2.add(card1);
        if (카드제출(myCards2))
            r = Math.max(r, 완전탐색(myCards2, coin - 1, top + 2));
    }

    if (coin > 0) {
        var myCards3 = new HashSet<>(myCards);
        myCards3.add(card2);
        if (카드제출(myCards3))
            r = Math.max(r, 완전탐색(myCards3, coin - 1, top + 2));
    }

    if (coin > 1) {
        var myCards4 = new HashSet<>(myCards);
        myCards4.add(card1);
        myCards4.add(card2);
        if (카드제출(myCards4))
            r = Math.max(r, 완전탐색(myCards4, coin - 2, top + 2));
    }
    return r + 1;
}

public int solution(int coin, int[] cards) {
    this.cards = cards;
    this.N = cards.length;
    var myCards = new HashSet<Integer>();
    for (int i = 0; i < N/3; ++i)
        myCards.add(cards[i]);
    return 완전탐색(myCards, coin, N/3);
}
    }

    public static void main(String[] args) {
        int[][] cards = {{3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4},
             {1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11, 12},
             {5, 8, 1, 2, 9, 4, 12, 11, 3, 10, 6, 7},
             {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18}};
        int[] coin = {4, 3, 2, 10};
        for (int i = 0; i < cards.length; ++i)
            System.out.println(new Solution().solution(coin[i], cards[i]));

    }

}