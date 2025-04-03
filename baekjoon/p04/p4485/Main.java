package baekjoon.p04.p4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int r, c, distance;

        public Node(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node n) {
            return distance - n.distance;
        }
    }

    static int dijkstra(int[][] A, int N) {
        boolean[][] visited = new boolean[N][N];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0, A[0][0]));
        while (queue.size() > 0) {
            Node node = queue.remove();
            int r = node.r, c = node.c, distance = node.distance;
            if (r == N-1 && c == N-1) return node.distance;
            if (visited[r][c]) continue;
            visited[r][c] = true;
            if (r > 0) queue.add(new Node(r-1, c, distance + A[r-1][c]));
            if (c > 0) queue.add(new Node(r, c-1, distance + A[r][c-1]));
            if (r < N-1) queue.add(new Node(r+1, c, distance + A[r+1][c]));
            if (c < N-1) queue.add(new Node(r, c+1, distance + A[r][c+1]));
        }
        return -1;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int test = 1; true; ++test) {
            int N = Integer.parseInt(reader.readLine());
            if (N == 0) break;
            int[][] A = new int[N][N];
            for (int r = 0; r < N; ++r) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int c = 0; c < N; ++c)
                    A[r][c] = Integer.parseInt(tokenizer.nextToken());

            }
            System.out.printf("Problem %d: %d\n", test, dijkstra(A, N));
        }
    }
}