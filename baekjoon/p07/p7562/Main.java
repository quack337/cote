package baekjoon.p07.p7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int r, c, distance;

        public Node(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }

    static final int[][] moves = new int[][] {
        {+2,+1}, {+1,+2}, {+2,-1}, {+1,-2}, {-2,+1}, {-1,+2}, {-2,-1}, {-1,-2}
    };

    static int BFS(int N, int r0, int c0, int r1, int c1) {
        boolean[][] visited = new boolean[N][N];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(r0, c0, 0));
        while (queue.size() > 0) {
            Node node = queue.remove();
            if (node.r == r1 && node.c == c1) return node.distance;
            if (node.r < 0 || node.r >= N) continue;
            if (node.c < 0 || node.c >= N) continue;
            if (visited[node.r][node.c]) continue;
            visited[node.r][node.c] = true;
            for (int[] move : moves)
                queue.add(new Node(node.r + move[0], node.c + move[1], node.distance+1));
        }
        return 0;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int test = 0; test < T; ++test) {
            int N = Integer.parseInt(reader.readLine());
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int r0 = Integer.parseInt(tokenizer.nextToken());
            int c0 = Integer.parseInt(tokenizer.nextToken());
            tokenizer = new StringTokenizer(reader.readLine());
            int r1 = Integer.parseInt(tokenizer.nextToken());
            int c1 = Integer.parseInt(tokenizer.nextToken());
            System.out.println(BFS(N, r0, c0, r1, c1));
        }
    }
}
