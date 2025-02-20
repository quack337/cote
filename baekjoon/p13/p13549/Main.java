package baekjoon.p13.p13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 100000;

    static class Location implements Comparable<Main.Location> {
        int n, distance;

        public Location(int n, int distance) {
            this.n = n;
            this.distance = distance;
        }

        @Override
        public int compareTo(Location o) {
            return distance - o.distance;
        }
    }

    static int BFS(int N, int K) {
        PriorityQueue<Location> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[MAX+1];
        queue.add(new Location(N, 0));
        while (queue.size() > 0) {
            Location current = queue.remove();
            if (current.n == K) return current.distance;
            if (current.n < 0 || current.n > MAX) continue;
            if (visited[current.n]) continue;
            visited[current.n] = true;
            queue.add(new Location(current.n-1, current.distance+1));
            queue.add(new Location(current.n+1, current.distance+1));
            queue.add(new Location(current.n*2, current.distance));
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
