package programmers.p12905;

public class Main1 {

    static class Solution
    {
        boolean 확인(int[][] A, int row, int col, int size) {
            int s = size - 1;
            for (int i = 0; i < size; ++i) {
                if (row + s >= A.length) return false;
                if (col + s >= A[0].length) return false;
                if (A[row + s][col + i] != 1) return false;
                if (A[row + i][col + s] != 1) return false;
            }
            return true;
        }

        int 크기(int[][] A, int row, int col) {
            int size = 1;
            while (true) {
                if (확인(A, row, col, size) == false)
                    return size - 1;
                ++size;
            }
        }

        public int solution(int[][] A)
        {
            int max = 0;
            for (int r = 0; r < A.length; ++r)
                for (int c = 0; c < A[0].length; ++c) {
                    int size = 크기(A, r, c);
                    if (size > max) max = size;
                }
            return max * max;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        System.out.println(sol.solution(new int[][] {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}}));
        System.out.println(sol.solution(new int[][] {{0,0,1,1},{1,1,1,1}}));
    }
}