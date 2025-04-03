package programmers.e92344;

public class Main1 {

    static class Solution {
        public int solution(int[][] board, int[][] skill) {
            int[][] A = new int[board.length][board[0].length];
            for (int[] s : skill) {
                int type=s[0], r1=s[1], c1=s[2], r2=s[3], c2=s[4], degree=s[5];
                if (type == 1) degree *= -1;
                for (int r = r1; r <= r2; ++r) {
                    A[r][c1] += degree;
                    if (c2 + 1 < board[0].length) A[r][c2 + 1] += -degree;
                }
            }
            for (int r = 0; r < board.length; ++r)
                for (int c = 1; c < board[0].length; ++c)
                    A[r][c] = A[r][c] + A[r][c - 1];
            int answer = 0;
            for (int r = 0; r < board.length; ++r)
                for (int c = 0; c < board[0].length; ++c)
                    if (board[r][c] + A[r][c] > 0) ++answer;
            return answer;
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] board1 = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][] skill1 = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        System.out.println(sol.solution(board1, skill1)); // 10

        int[][] board2 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] skill2 = {{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}};
        System.out.println(sol.solution(board2, skill2)); // 6

        int[][] board3 = {{0}};
        int[][] skill3 = {{2,0,0,0,0,2}};
        System.out.println(sol.solution(board3, skill3)); // 1


    }
}