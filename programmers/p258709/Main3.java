package programmers.p258709;

import java.util.ArrayList;
import java.util.Arrays;

public class Main3 {

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

        void 주사위눈조합(int diceNo, int[] faces, Selection selection) {
            if (diceNo == N) {
                int 점수A = 0, 점수B = 0;
                for (int i = 0; i < N/2; ++i) {
                    int diceA = selection.A[i], diceB = selection.B[i];
                    점수A += dice[diceA][faces[diceA]];
                    점수B += dice[diceB][faces[diceB]];
                }
                if (점수A > 점수B) selection.승++;
                else if (점수A < 점수B) selection.패++;
                else selection.무++;
                return;
            }
            for (int face = 0; face < 6; ++face) {
                faces[diceNo] = face;
                주사위눈조합(diceNo + 1, faces, selection);
            }
        }

        public int[] solution(int[][] dice) {
            this.dice = dice;
            this.N = dice.length;

            선택조합(0, new int[N/2], new int[N/2], 0, 0);

            for (Selection selection : selections)
                주사위눈조합(0, new int[N], selection);

            Selection max = selections.get(0);
            for (int i = 1; i < selections.size(); ++i) {
                Selection selection = selections.get(i);
                if ((selection.승 > max.승) || (selection.승 == max.승 && selection.무 > max.무))
                    max = selection;
            }
            for (int i = 0; i < max.A.length; ++i)
                max.A[i]++;
            return max.A;
        }
    }

    public static void main(String[] args) {
        int[][] e1 = {{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}};
        System.out.println(Arrays.toString(new Solution().solution(e1)));

        int[][] e2 = {{1, 2, 3, 4, 5, 6}, {2, 2, 4, 4, 6, 6}};
        System.out.println(Arrays.toString(new Solution().solution(e2)));

        int[][] e3 = {{40, 41, 42, 43, 44, 45}, {43, 43, 42, 42, 41, 41}, {1, 1, 80, 80, 80, 80},
                {70, 70, 1, 1, 70, 70}};
        System.out.println(Arrays.toString(new Solution().solution(e3)));
    }
}