package programmers.p258709;
import java.util.ArrayList;
import java.util.Arrays;

public class Main1 {

    static class Solution {

        static class Selection {
            int 승, 무, 패;
            int[] A, B;
        }

        ArrayList<Selection> selections = new ArrayList<Selection>();
        int[][] dice;
        int N;

        void 선택조합(int diceNo, int[] A, int[] B, int countA, int countB) {
            if (countA == N/2 && countB == N/2) {
                var selection = new Selection();
                selection.A = Arrays.copyOf(A, N/2);
                selection.B = Arrays.copyOf(B, N/2);
                selections.add(selection);
                return;
            }
            if (countA < N/2) {
                A[countA] = diceNo;
                선택조합(diceNo + 1, A, B, countA + 1, countB);
            }
            if (countB < N/2) {
                B[countB] = diceNo;
                선택조합(diceNo + 1, A, B, countA, countB + 1);
            }
        }

        public int[] solution(int[][] dice) {
            this.dice = dice;
            this.N = dice.length;

            선택조합(0, new int[N/2], new int[N/2], 0, 0);

            for (Selection selection : selections)
                System.out.printf("%s %s\n",
                        Arrays.toString(selection.A), Arrays.toString(selection.B));

            return null;
        }
    }

    public static void main(String[] args) {
        int[][] e1 = {{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}};
        new Solution().solution(e1); System.out.println();

        int[][] e2 = {{1, 2, 3, 4, 5, 6}, {2, 2, 4, 4, 6, 6}};
        new Solution().solution(e2); System.out.println();

        int[][] e3 = {{40, 41, 42, 43, 44, 45}, {43, 43, 42, 42, 41, 41}, {1, 1, 80, 80, 80, 80},
                {70, 70, 1, 1, 70, 70}};
        new Solution().solution(e3); System.out.println();
    }
}