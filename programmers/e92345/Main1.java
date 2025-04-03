package programmers.e92345;

import java.util.TreeSet;

public class Main1 {

    static class Solution {
static class Node {
    int ar, ac, br, bc, distance;
    int[][] board;

    @Override
    public Node clone() {
        Node node = new Node();
        node.ar = this.ar; node.ac = this.ac;
        node.br = this.br; node.bc = this.bc;
        node.board = this.board.clone();
        node.distance = this.distance + 1;
        for (int i = 0; i < this.board.length; ++i)
            node.board[i] = this.board[i].clone();
        return node;
    }

    public boolean isValid(int r, int c) {
        return 0 <= r && r < board.length && 0 <= c && c < board[0].length && board[r][c]==1;
    }
}

static int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

int max(Node node) {
    if (node.board[node.ar][node.ac] == 0) return -node.distance;
    var result = new TreeSet<Integer>();
    for (int[] move : moves) {
        Node node1 = node.clone();
        node1.board[node1.ar][node1.ac] = 0;
        node1.ar += move[0]; node1.ac += move[1];
        if (node1.isValid(node1.ar, node1.ac) == false) continue;
        result.add(min(node1));
    }
    if (result.size() == 0) return -node.distance; // A 패배
    if (result.last() < 0) return result.first(); // 승리할 수 없다면, 절대값이 큰 음수
    return result.ceiling(0); // 승리할 수 있다면 절대rkqt이 작은 양수
}

int min(Node node) {
    if (node.board[node.br][node.bc] == 0) return node.distance;
    var result = new TreeSet<Integer>();
    for (int[] move : moves) {
        Node node1 = node.clone();
        node1.board[node1.br][node1.bc] = 0;
        node1.br += move[0]; node1.bc += move[1];
        if (node1.isValid(node1.br, node1.bc) == false) continue;
        result.add(max(node1));
    }
    if (result.size() == 0) return node.distance; // B 패배
    if (result.first() >= 0) return result.last(); // 승리할 수 없다면, 절대값이 큰 양수
    return result.floor(0); // 승리할 수 있다면 절대값이 작은 음수
}

public int solution(int[][] board, int[] A, int[] B) {
    Node node = new Node();
    node.ar = A[0]; node.ac = A[1];
    node.br = B[0]; node.bc = B[1];
    node.board = board;
    return Math.abs(max(node));
}
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] board1 = {{1,1,1},{1,1,1},{1,1,1}}; int[] A1 = {1,0}, B1={1,2};
        System.out.println(sol.solution(board1, A1, B1));

        int[][] board2 = {{1,1,1},{1,0,1},{1,1,1}}; int[] A2 = {1,0}, B2={1,2};
        System.out.println(sol.solution(board2, A2, B2));

        System.out.println(sol.solution(new int[][] {{1,1,1,1,1}}, new int[] {0,0}, new int[] {0,4}));
        System.out.println(sol.solution(new int[][] {{1}}, new int[] {0,0}, new int[] {0,0}));
    }

}