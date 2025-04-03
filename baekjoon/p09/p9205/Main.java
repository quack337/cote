package baekjoon.p09.p9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distance(Node node) {
            return Math.abs(x - node.x) + Math.abs(y - node.y);
        }
    }

    static boolean BFS(Node[] node) {
        int N = node.length;
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        while (queue.size() > 0) {
            int current = queue.remove();
            if (current == N-1) return true;
            if (visited[current]) continue;
            visited[current] = true;
            for (int i = 1; i < N; ++i) {
                int distance = node[current].distance(node[i]);
                if (distance <= 50 * 20) queue.add(i);
            }
        }
        return false;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();
        for (int test = 0; test < T; ++test) {
            int N = Integer.parseInt(reader.readLine());
            Node[] node = new Node[N+2];
            for (int i = 0; i < N+2; ++i) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(tokenizer.nextToken());
                int y = Integer.parseInt(tokenizer.nextToken());
                node[i] = new Node(x, y);
            }
            builder.append(BFS(node) ? "happy\n" : "sad\n");
        }
        System.out.println(builder.toString());
    }
}