package programmers.p12949;
import java.util.Arrays;

public class Main {

    static class Solution {
        public int[][] solution(int[][] A, int[][] B) {
            int rowSize = A.length, colSize = B[0].length;
            int[][] C = new int[rowSize][colSize];
            for (int r = 0; r < rowSize; ++r)
                for (int c = 0; c < colSize; ++c)
                    for (int i = 0; i < B.length; ++i)
                        C[r][c] += A[r][i] * B[i][c];
            return C;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        int[][] r1 = sol.solution(new int[][] {{1,4},{3,2},{4,1}}, new int[][] {{3,3},{3,3}});
        System.out.println(Arrays.deepToString(r1));
        int[][] r2 = sol.solution(new int[][] {{2,3,2},{4,2,4},{3,1,4}}, new int[][] {{5,4,3},{2,4,1},{3,1,1}});
        System.out.println(Arrays.deepToString(r2));
    }
}