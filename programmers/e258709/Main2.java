import java.util.Arrays;

public class Main2 {

    static class Solution {

        int[][] dice;
        int N;

        void 주사위눈조합(int diceNo, int[] faces) {
            if (diceNo == N) {
                System.out.print(Arrays.toString(faces) + " ");
                return;
            }
            for (int face = 0; face < 6; ++face) {
                faces[diceNo] = face;
                주사위눈조합(diceNo + 1, faces);
            }
        }

        public int[] solution(int[][] dice) {
            this.dice = dice;
            this.N = dice.length;

            주사위눈조합(0, new int[N]);

            return null;
        }
    }

    public static void main(String[] args) {
        int[][] e1 = {{1, 2, 3, 4, 5, 6}};
        new Solution().solution(e1); System.out.println("\n");

        int[][] e2 = {{1, 2, 3, 4, 5, 6}, {1, 2, 3, 4, 5, 6}};
        new Solution().solution(e2); System.out.println("\n");

        int[][] e3 = {{1, 2, 3, 4, 5, 6}, {1, 2, 3, 4, 5, 6}, {1, 2, 3, 4, 5, 6}};
        new Solution().solution(e3);
    }
}