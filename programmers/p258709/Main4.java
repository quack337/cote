package programmers.p258709;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main4 {

    static class Solution {

        static class Selection {
            int[] A, B;
            int 승, 무, 패;
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

        ArrayList<Integer> 점수A목록;
        ArrayList<Integer> 점수B목록;

        void 주사위눈조합(int diceNo, int[] faces, Selection selection) {
            if (diceNo == N/2) {
                int 점수A = 0, 점수B = 0;
                for (int i = 0; i < N/2; ++i) {
                    int diceA = selection.A[i], diceB = selection.B[i];
                    점수A += dice[diceA][faces[i]];
                    점수B += dice[diceB][faces[i]];
                }
                점수A목록.add(점수A);
                점수B목록.add(점수B);
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

            for (Selection selection : selections) {
                점수A목록 = new ArrayList<>();
                점수B목록 = new ArrayList<>();
                주사위눈조합(0, new int[N], selection);
                Collections.sort(점수B목록);
                for (int 점수A : 점수A목록) {
                    int index = Collections.binarySearch(점수B목록, 점수A);
                    if (index < 0) index = -index - 1;
                    if (index == 점수B목록.size()) index = 점수B목록.size() - 1;
                    int low = index, high = index;
                    while (low >= 0 && 점수B목록.get(low) >= 점수A)
                        --low;
                    while (high < 점수B목록.size() && 점수B목록.get(high) <= 점수A)
                        ++high;
                    selection.승 += low + 1;
                    selection.패 += 점수B목록.size() - high;
                    selection.무 += high - low - 1;
                }
            }
            Collections.max(selections, (x, y) -> (y.승 != x.승) ? y.승 - x.승 : y.무 - x.무);
            int[] answer = selections.get(0).A;
            for (int i = 0; i < answer.length; ++i)
                answer[i]++;
            return answer;
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