package baekjoon.p12.p12851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 100000;

    static class Location {
        int n, distance;

        public Location(int n, int distance) {
            this.n = n;
            this.distance = distance;
        }
    }

    static int minDistance = Integer.MAX_VALUE, count = 0;

    static void BFS(int N, int K) {
        ArrayDeque<Location> queue = new ArrayDeque<>();
        int[] visited = new int[MAX+1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        queue.add(new Location(N, 0));
        while (queue.size() > 0) {
            Location current = queue.removeFirst();
            if (current.n == K) { // 목적지 도착
                if (count == 0) minDistance = current.distance;
                ++count;
            }
            if (current.distance > minDistance) return;
            if (current.n < 0 || current.n > MAX) continue;
            if (visited[current.n] < current.distance) continue;
            visited[current.n] = current.distance;
            queue.addLast(new Location(current.n-1, current.distance+1));
            if (K > N) queue.addLast(new Location(current.n+1, current.distance+1));
            if (K > N) queue.addLast(new Location(current.n*2, current.distance+1));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        BFS(N, K);
        System.out.println(minDistance);
        System.out.println(count);
    }
}
