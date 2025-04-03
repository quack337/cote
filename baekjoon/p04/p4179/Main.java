package baekjoon.p04.p4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[][] D = new int[][] {{-1,0}, {+1,0}, {0,-1}, {0,+1}};
    static int R, C;
    static char[][] map;

    static class Node {
        int r, c, distance;

        public Node(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }

    static int[][] fireBFS(List<Node> fireStart) {
        int[][] fireDistance = new int[R][C];
        for (int r = 0; r < R; ++r)
            Arrays.fill(fireDistance[r], Integer.MAX_VALUE);
        Queue<Node> queue = new ArrayDeque<>();
        queue.addAll(fireStart);
        while (queue.size() > 0) {
            Node current = queue.remove();
            int r = current.r, c = current.c, distance = current.distance;
            if (r < 0 || r >= R) continue;
            if (c < 0 || c >= C) continue;
            if (map[r][c] == '#') continue;
            if (fireDistance[r][c] < Integer.MAX_VALUE) continue;
            fireDistance[r][c] = distance;
            for (int[] d : D) {
                int r1 = r + d[0], c1 = c + d[1];
                queue.add(new Node(r1, c1, distance + 1));
            }
        }
        return fireDistance;
    }

    static int escapeBFS(Node start, int[][] fireDistance) {
        boolean[][] visited = new boolean[R][C];
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(start);
        while (queue.size() > 0) {
            Node current = queue.remove();
            int r = current.r, c = current.c, distance = current.distance;
            if (r < 0 || r >= R) return distance;
            if (c < 0 || c >= C) return distance;
            if (map[r][c] == '#') continue;
            if (distance >= fireDistance[r][c]) continue;
            if (visited[r][c]) continue;
            visited[r][c] = true;
            for (int[] d : D) {
                int r1 = r + d[0], c1 = c + d[1];
                queue.add(new Node(r1, c1, distance + 1));
            }
        }
        return -1;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        map = new char[R][];
        List<Node> fireStart = new ArrayList<>();
        Node start = null;
        for (int r = 0; r < R; ++r) {
            map[r] = reader.readLine().toCharArray();
            for (int c = 0; c < C; ++c) {
                if (map[r][c] == 'F') fireStart.add(new Node(r, c, 0));
                else if (map[r][c] == 'J') start = new Node(r, c, 0);
            }
        }
        int[][] fireDistance = fireBFS(fireStart);
        int distance = escapeBFS(start, fireDistance);
        System.out.println(distance < 0 ? "IMPOSSIBLE" : distance);
    }
}