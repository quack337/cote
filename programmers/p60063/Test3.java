package programmers.p60063;

import java.util.ArrayDeque;

public class Test3 {

    static class Solution {
        static class Node {
            int y, x, d, y2, x2, distance;

            public Node(int y, int x, int d, int distance) {
                this.y = y; this.x = x; this.d = d;
                this.distance = distance;
                this.y2 = (d == 0 ? y : y + 1);
                this.x2 = (d == 0 ? x + 1 : x);
            }
        }

        int N;
        int[][] board;

        boolean 빈칸(int y, int x) {
            if (y < 0 || y >= N || x < 0 || x >= N) return false;
            return board[y][x] == 0;
        }

        Node 이동(Node node, int i) {
            final int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};
            return new Node(node.y + d[i][0], node.x + d[i][1], node.d, node.distance+1);
        }

        boolean 회전가능(Node node, int i) {
            final int[][] d = {{1,1},{-1,1},{-1,0},{1,0},{1,-1},{1,1},{0,1},{0,-1}};
            if ((node.d == 0 && i > 3) || (node.d == 1 && i < 4)) return false;
            return 빈칸(node.y + d[i][0], node.x + d[i][1]);
        }

        Node 회전(Node node, int i) {
            final int[][] d = {{0,0,1},{-1,0,1},{-1,+1,1},{0,+1,1},{0,-1,0},{0,0,0},{+1,0,0},{+1,-1,0}};
            return new Node(node.y + d[i][0], node.x + d[i][1], d[i][2], node.distance + 1);
        }

        public int solution(int[][] board) {
            this.N = board.length;
            this.board = board;
            boolean[][][] visited = new boolean[N][N][2];
            ArrayDeque<Node> queue = new ArrayDeque<>();
            queue.add(new Node(0,0,0,0));
            while (queue.size() > 0) {
                Node node = queue.remove();
                if (visited[node.y][node.x][node.d]) continue;
                if ((node.y==N-1 && node.x == N-2) || (node.y==N-2 && node.x==N-1)) return node.distance;
                visited[node.y][node.x][node.d] = true;
                for (int i = 0; i < 4; ++i) {
                    Node node2 = 이동(node, i);
                    if (!빈칸(node2.y,  node2.x) || !빈칸(node2.y2, node2.x2)) continue;
                    if (visited[node2.y][node2.x][node2.d]) continue;
                    queue.add(node2);
                }
                for (int i = 0; i < 8; ++i) {
                    if (회전가능(node, i) == false) continue;
                    Node node2 = 회전(node, i);
                    if (!빈칸(node2.y,  node2.x) || !빈칸(node2.y2, node2.x2)) continue;
                    if (visited[node2.y][node2.x][node2.d]) continue;
                    queue.add(node2);
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[][] b1 = {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
        System.out.println(new Solution().solution(b1)); // 7

        System.out.println(new Solution().solution(new int[][] {{0,0,0,0,1,0},{0,0,1,1,1,0},{0,1,1,1,1,0},{0,1,0,0,1,0},{0,0,1,0,0,0},{0,0,0,0,0,0}})); // 10
        System.out.println(new Solution().solution(new int[][] {{0,0,0,0,0,0,1},{1,1,1,1,0,0,1},{0,0,0,0,0,0,0},{0,0,1,1,1,1,0},{0,1,1,1,1,1,0},{0,0,0,0,0,1,1},{0,0,1,0,0,0,0}})); // 21
    }

}