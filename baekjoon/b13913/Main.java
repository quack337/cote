package baekjoon.b13913;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 100000;

    static class Location {
        int n, distance;
        Location parent;

        public Location(int n, int distance, Location parent) {
            this.n = n;
            this.distance = distance;
            this.parent = parent;
        }
    }

    static Location BFS(int N, int K) {
        ArrayDeque<Location> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[MAX+1];
        queue.add(new Location(N, 0, null));
        while (queue.size() > 0) {
            Location current = queue.removeFirst();
            if (current.n == K) return current;
            if (current.n < 0 || current.n > MAX) continue;
            if (visited[current.n]) continue;
            visited[current.n] = true;
            queue.addLast(new Location(current.n-1, current.distance+1, current));
            queue.addLast(new Location(current.n+1, current.distance+1, current));
            queue.addLast(new Location(current.n*2, current.distance+1, current));
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        Location p = BFS(N, K);
        System.out.println(p.distance);
        StringBuilder builder = new StringBuilder();
        while (p != null) {
            builder.insert(0, p.n + " ");
            p = p.parent;
        }
        System.out.println(builder.toString());
    }
}