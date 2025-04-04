package baekjoon.b05.p5427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    static int R, C;
    static char[][] map;

    static int[][] fireBFS(List<Node> start) {
        int[][] fireDistance = new int[R][C];
        for (int[] a : fireDistance)
            Arrays.fill(a, Integer.MAX_VALUE);
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addAll(start);
        while (queue.size() > 0) {
            Node node = queue.remove();
            int r = node.r, c = node.c, distance = node.distance;
            if (r < 0 || r >= R) continue;
            if (c < 0 || c >= C) continue;
            if (map[r][c] == '#') continue;
            if (fireDistance[r][c] <= distance) continue;
            fireDistance[r][c] = distance;
            queue.add(new Node(r-1, c, distance+1));
            queue.add(new Node(r+1, c, distance+1));
            queue.add(new Node(r, c-1, distance+1));
            queue.add(new Node(r, c+1, distance+1));
        }
        return fireDistance;
    }

    static int escapeBFS(Node start, int[][] fireDistance) {
        boolean[][] visited = new boolean[R][C];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(start);
        while (queue.size() > 0) {
            Node node = queue.remove();
            int r = node.r, c = node.c, distance = node.distance;
            if (r < 0 || r >= R) return distance;
            if (c < 0 || c >= C) return distance;
            if (map[r][c] == '#') continue;
            if (fireDistance[r][c] <= distance) continue;
            if (visited[r][c]) continue;
            visited[r][c] = true;
            queue.add(new Node(r-1, c, distance+1));
            queue.add(new Node(r+1, c, distance+1));
            queue.add(new Node(r, c-1, distance+1));
            queue.add(new Node(r, c+1, distance+1));
        }
        return Integer.MAX_VALUE;
    }

    static List<Node> find(char ch) {
        List<Node> result = new ArrayList<>();
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c)
                if (map[r][c] == ch)
                    result.add(new Node(r, c, 0));
        return result;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int test = 0; test < T; ++test) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            C = Integer.parseInt(tokenizer.nextToken());
            R = Integer.parseInt(tokenizer.nextToken());
            map = new char[R][];
            for (int r = 0; r < R; ++r)
                map[r] = reader.readLine().toCharArray();

            int[][] fireDistance = fireBFS(find('*'));
            Node start = find('@').get(0);
            int distance = escapeBFS(start, fireDistance);
            System.out.println(distance == Integer.MAX_VALUE ? "IMPOSSIBLE" : distance);
        }
    }
}