package baekjoon.b05.p5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int floor, distance;

        public Node(int floor, int distance) {
            this.floor = floor;
            this.distance = distance;
        }
    }

    static int F, S, G, U, D;

    static int BFS() {
        boolean[] visited = new boolean[F+1];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(S, 0));
        while (queue.size() > 0) {
            Node current = queue.remove();
            if (current.floor < 1) continue;
            if (current.floor > F) continue;
            if (visited[current.floor]) continue;
            if (current.floor == G) return current.distance;
            visited[current.floor] = true;
            if (U > 0) queue.add(new Node(current.floor + U, current.distance + 1));
            if (D > 0) queue.add(new Node(current.floor - D, current.distance + 1));
        }
        return -1;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        F = Integer.parseInt(tokenizer.nextToken());
        S = Integer.parseInt(tokenizer.nextToken());
        G = Integer.parseInt(tokenizer.nextToken());
        U = Integer.parseInt(tokenizer.nextToken());
        D = Integer.parseInt(tokenizer.nextToken());
        int distance = BFS();
        System.out.println(distance == -1 ? "use the stairs" : distance);
    }
}