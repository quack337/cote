import java.util.HashSet;
import java.util.Set;

public class Main2 {

    static class Solution {
        int N;

        boolean 카드제출(Set<Integer> cards) {
            for (int c : cards)
                if (cards.contains(N + 1 - c)) {
                    cards.remove(c);
                    cards.remove(N + 1 - c);
                    return true;
                }
            return false;
        }

        public int solution(int coin, int[] cards) {
            N = cards.length;
            var 떨군카드 = new HashSet<Integer>();
            var 내카드 = new HashSet<Integer>();
            int round = 1, top = 0;
            while (top < N/3)
                내카드.add(cards[top++]);
            while (true) {
                if (top == N) return round;
                int card1 = cards[top], card2 = cards[top + 1];
                if (coin > 0 && 내카드.contains(N + 1 - card1)) {
                    내카드.add(card1);
                    --coin;
                } else
                    떨군카드.add(card1);
                if (coin > 0 && 내카드.contains(N + 1 - card2)) {
                    내카드.add(card2);
                    --coin;
                } else
                    떨군카드.add(card2);
                if (카드제출(내카드) == false) {
                    if (coin < 2 || 카드제출(떨군카드) == false)
                        return round;
                    coin -= 2;
                }
                top += 2;
                ++round;
            }
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