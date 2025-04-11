package baekjoon.b1261;
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

    static int dijstra(char[][] A, int N, int M) {
        boolean[][] visited = new boolean[N][M];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0, (A[0][0] - '0')));
        while (queue.size() > 0) {
            Node node = queue.remove();
            int r = node.r, c = node.c, distance = node.distance;
            if (r < 0 || r >= N) continue;
            if (c < 0 || c >= M) continue;
            if (r == N-1 && c == M-1) return distance;
            if (visited[r][c]) continue;
            visited[r][c] = true;
            if (r > 0) queue.add(new Node(r-1, c, distance + (A[r-1][c] - '0')));
            if (c > 0) queue.add(new Node(r, c-1, distance + (A[r][c-1] - '0')));
            if (r < N-1) queue.add(new Node(r+1, c, distance + (A[r+1][c] - '0')));
            if (c < M-1) queue.add(new Node(r, c+1, distance + (A[r][c+1] - '0')));
        }
        return -1;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int M = Integer.parseInt(tokenizer.nextToken());
        int N = Integer.parseInt(tokenizer.nextToken());
        char[][] A = new char[N][];
        for (int i = 0; i < N; ++i)
            A[i] = reader.readLine().toCharArray();
        System.out.println(dijstra(A, N, M));
    }
}