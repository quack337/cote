package programmers.p42894;
public class Test1 {

    static class Solution {

        boolean black(int[][] board, int row, int col) {
            for (int r = row; r >= 0; --r)
                if (board[r][col] != 0)
                    return false;
            return true;
        }

        boolean 채울수있나(int[][] board, int row, int col, int rowSize, int colSize) {
            int color = board[row][col];
            int blackCount = 0;
            for (int r = row; r < row + rowSize; ++r)
                for (int c = col; c < col + colSize; ++c) {
                    if (r >= board.length || c >= board.length) return false;
                    if (board[r][c] == 0) {
                        if (!black(board, r, c)) return false;
                        if (++blackCount > 2) return false;
                    } else {
                        if (color == 0) color = board[r][c];
                        else if (color != board[r][c]) return false;
                    }
                }
            return true;
        }

        void 제거(int[][] board, int row, int col, int rowSize, int colSize) {
            for (int r = row; r < row + rowSize; ++r)
                for (int c = col; c < col + colSize; ++c)
                    board[r][c] = 0;
        }

        public int solution(int[][] board) {
            final int[][] SIZES = {{3, 2}, {2, 3}};
            int count = 0;
            for (int r = 0; r < board.length; ++r)
                for (int c = 0; c < board.length; ++c)
                    for (int[] size : SIZES)
                        if (채울수있나(board, r, c, size[0], size[1])) {
                            ++count;
                            제거(board, r, c, size[0], size[1]);
                        }
            return count;
        }
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},
                         {0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,4,0,0,0},{0,0,0,0,0,4,4,0,0,0},
                         {0,0,0,0,3,0,4,0,0,0},{0,0,0,2,3,0,0,0,5,5},{1,2,2,2,3,3,0,0,0,5},
                         {1,1,1,0,0,0,0,0,0,5}};
        System.out.println(new Solution().solution(board));
    }
}