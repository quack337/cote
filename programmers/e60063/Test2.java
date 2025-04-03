package programmers.e60063;

import java.util.ArrayDeque;
import java.util.HashSet;

public class Test2 {

    static class Solution {

        static class Node {
            int y, x, d, distance;

            public Node(int y, int x, int d, int distance) {
                this.y = y; this.x = x; this.d = d;
                this.distance = distance;
            }

            @Override
            public int hashCode() {
                return (d << 16) + (y << 8) + x;
            }

            @Override
            public boolean equals(Object node) {
                return this.hashCode() == ((Node)node).hashCode();
            }

            int y2() { return d == 0 ? y : y + 1; }
            int x2() { return d == 0 ? x + 1 : x; }
        }

        int N;
        int[][] board;

        boolean 빈칸(int y, int x) {
            if (y < 0 || y >= N || x < 0 || x >= N) return false;
            return board[y][x] == 0;
        }

        boolean 이동가능(Node node) {
            return 빈칸(node.y,  node.x) && 빈칸(node.y2(), node.x2());
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
            final Node goal1=new Node(N-1,N-2,0,0), goal2=new Node(N-2,N-1,1,0);
            HashSet<Node> visited = new HashSet<>();
            ArrayDeque<Node> queue = new ArrayDeque<>();
            queue.add(new Node(0,0,0,0));
            while (queue.size() > 0) {
                Node node = queue.remove();
                if (visited.contains(node)) continue;
                if (node.equals(goal1) || node.equals(goal2)) return node.distance;
                visited.add(node);
                for (int i = 0; i < 4; ++i) {
                    Node node2 = 이동(node, i);
                    if (이동가능(node2) == false) continue;
                    if (visited.contains(node2)) continue;
                    queue.add(node2);
                }
                for (int i = 0; i < 8; ++i) {
                    if (회전가능(node, i) == false) continue;
                    Node node2 = 회전(node, i);
                    if (이동가능(node2) == false) continue;
                    if (visited.contains(node2)) continue;
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