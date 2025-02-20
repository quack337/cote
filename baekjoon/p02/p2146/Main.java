package baekjoon.p02.p2146;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static class Node {
        int r, c, distance;

        public Node(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }

    static char[][] map;
    static int N;

    static void DFS(int r, int c, char from, char to) {
        if (r < 0 || r >= N) return;
        if (c < 0 || c >= N) return;
        if (map[r][c] != from) return;
        map[r][c] = to;
        DFS(r-1, c, from, to);
        DFS(r+1, c, from, to);
        DFS(r, c-1, from, to);
        DFS(r, c+1, from, to);
    }

    static int BFS(int row, int col) {
        boolean[][] visited = new boolean[N][N];
        char 출발대륙 = map[row][col];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(row, col, 0));
        while (queue.size() > 0) {
            Node node = queue.remove();
            int r = node.r, c = node.c, distance = node.distance;
            if (r < 0 || r >= N) continue;
            if (c < 0 || c >= N) continue;
            if (map[r][c] == 출발대륙 && distance > 0)
                continue; // 출발하는 칸만 출발대륙이어야 한다.
            if (map[r][c] != '0' && map[r][c] != 출발대륙)
                return distance; // 다른 대륙 발견
            if (visited[r][c]) continue;
            visited[r][c] = true;
            queue.add(new Node(r-1, c, distance+1));
            queue.add(new Node(r+1, c, distance+1));
            queue.add(new Node(r, c-1, distance+1));
            queue.add(new Node(r, c+1, distance+1));
        }
        return Integer.MAX_VALUE; // 실패
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        map = new char[N][];
        for (int r = 0; r < N; ++r)
            map[r] = reader.readLine().replaceAll(" ", "").toCharArray();

        // 대륙의 문자를 '2', '3', '4'... 로 바꾼다.
        char id = '1';
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                if (map[r][c] == '1') DFS(r, c, '1', ++id);

        // 대륙과 대륙 사이 최단 거리를 찾는다.
        int minDistance = Integer.MAX_VALUE;
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                if (map[r][c] != '0')
                    minDistance = Math.min(minDistance, BFS(r, c));
        System.out.println(minDistance - 1);
    }
}
