package baekjoon.p01.p1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main2 {
    static final int MAX = 100000;

    static class Location {
        int n, distance;

        public Location(int n, int distance) {
            this.n = n;
            this.distance = distance;
        }
    }

    static int BFS(int N, int K) {
        ArrayDeque<Location> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[MAX+1];
        queue.add(new Location(N, 0));
        while (queue.size() > 0) {
            Location current = queue.removeFirst();
            if (current.n == K) return current.distance;
            if (visited[current.n]) continue;
            visited[current.n] = true;
            queue.addLast(new Location(current.n-1, current.distance+1));
            queue.addLast(new Location(current.n+1, current.distance+1));
            queue.addLast(new Location(current.n*2, current.distance+1));
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        System.out.println(BFS(N, K));
    }
}
