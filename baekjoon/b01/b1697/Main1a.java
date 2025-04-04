package baekjoon.b01.b1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main1a {
    static final int MAX = 100000;

    static class Location {
        int n, distance;

        public Location(int n, int distance) {
            this.n = n;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        ArrayDeque<Location> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[MAX+1];
        queue.add(new Location(N, 0));
        while (queue.size() > 0) {
            Location current = queue.removeFirst();
            if (current.n == K) { System.out.println(current.distance); break; }
            if (current.n < 0 || current.n > MAX) continue;
            if (visited[current.n]) continue;
            visited[current.n] = true;
            queue.addLast(new Location(current.n-1, current.distance+1));
            queue.addLast(new Location(current.n+1, current.distance+1));
            queue.addLast(new Location(current.n*2, current.distance+1));
        }
    }
}