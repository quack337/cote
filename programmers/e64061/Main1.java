public class Main1 {

    static class Solution {
        public int solution(int[][] board, int[] moves) {
            int[] stack = new int[board.length * board.length];
            int top = 0, count = 0;
            for (int 열 : moves) {
                --열;
                for (int 행 = 0; 행 < board.length; ++행) {
                    if (board[행][열] != 0) {
                        if (stack[top] != board[행][열])
                            stack[++top] = board[행][열];
                        else {
                            --top;
                            count += 2;
                        }
                        board[행][열] = 0;
                        break;
                    }
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        Solution sol = new Solution();
        System.out.println(sol.solution(board, moves));
    }
}