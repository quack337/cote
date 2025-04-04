package baekjoon.b09.p9019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main1 {
    static class Node {
        int n, distance;

        public Node(int n, int distance) {
            this.n = n;
            this.distance = distance;
        }
    }

    static final int MAX = 10000;

    static int D(int n) { return (n * 2) % 10000; }
    static int S(int n) { return (n - 1 + 10000) % 10000; }
    static int L(int n) { return (n * 10 + n / 1000) % 10000; }
    static int R(int n) { return n / 10 + n % 10 * 1000; }

    static Node BFS(int start, int end) {
        boolean[] visited = new boolean[MAX];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(start, 0));
        while (queue.size() > 0) {
            Node current = queue.remove();
            if (current.n < 0 || current.n >= MAX) continue;
            if (current.n == end) return current;
            if (visited[current.n]) continue;
            visited[current.n] = true;
            queue.add(new Node(D(current.n), current.distance + 1));
            queue.add(new Node(S(current.n), current.distance + 1));
            queue.add(new Node(L(current.n), current.distance + 1));
            queue.add(new Node(R(current.n), current.distance + 1));
        }
        return null;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int test = 0; test < T; ++test) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            System.out.println(BFS(a, b).distance);
        }
    }
}