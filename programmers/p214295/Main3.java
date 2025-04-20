package programmers.p214295;
public class Main3 {

    static class Solution {
        static final int X = 0, Y = 1, D = 2, FLAG = 3;
        char[][] A;
        char[][] B;

        int distance(int x1, int y1, int x2, int y2) {
            return Math.abs(x1 - x2) + Math.abs(y1 - y2);
        }

        int count() {
            int r = 0, max = 0;
            for (int x = 0; x < A.length; ++x)
                for (int y = 0; y < A[0].length; ++y)
                    if (B[x][y] == 0 && A[x][y] > max) max = A[x][y];
            for (int x = 0; x < A.length; ++x)
                for (int y = 0; y < A[0].length; ++y)
                    if (B[x][y] == 0 && A[x][y] == max) ++r;
            return r;
        }

        public long solution(int n, int m, int[][] tests) {
            A = new char[n+1][m+1];
            B = new char[n+1][m+1];
            for (var test : tests) {
                int x0 = test[X], y0 = test[Y], d = test[D];
                for (int x = 0; x <= n; ++x)
                    for (int y = 0; y <= m; ++y)
                        if (distance(x0, y0, x, y) <= d)
                            if (test[FLAG] == 0)
                                B[x][y] = 1;
                            else
                                A[x][y]++;
                System.out.println(count());
            }
            return 0;
        }

    }

    public static void main(String[] args) {
        //System.out.println(new Solution().solution(3, 5, new int[][] {{2, 3, 2, 1}, {1, 0, 4, 0}, {0, 4, 1, 0}}));
        //System.out.println(new Solution().solution(99999, 99999, new int[][] {{0, 0, 199997, 1}}));
        //System.out.println(new Solution().solution(99999, 99999, new int[][] {{50000, 50000, 3, 0}}));
        //System.out.println(new Solution().solution(300, 100, new int[][] {{123, 28, 124, 1}, {183, 22, 34, 0}, {188, 81, 116, 1}, {167, 53, 33, 0}, {125, 55, 20, 0}}));
        //System.out.println(new Solution().solution(4, 4, new int[][] {{0,0,4,1},{2,2,1,1},{1,3,2,0},{2,1,1,0}}));
        //System.out.println(new Solution().solution(4, 4, new int[][] {{0,0,4,1},{0,0,2,0},{4,3,3,1},{1,4,3,0}}));

        System.out.println(new Solution().solution(300, 100, new int[][] {
            {123, 28, 124, 1},
            {188, 81, 116, 1},
            {183, 22, 34, 0},
            {167, 53, 33, 0},
            {125, 55, 20, 0}}));
    }

}