package baekjoon.b02.p2146;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main2 {
    static char[][] map;
    static int N;

    static void DFS(int r, int c, char from, char to) {
        if (r < 0 || r >= N || c < 0 || c >= N) return;
        if (map[r][c] != from) return;
        map[r][c] = to;
        DFS(r-1, c, from, to);
        DFS(r+1, c, from, to);
        DFS(r, c-1, from, to);
        DFS(r, c+1, from, to);
    }

    static int BFS(int 대륙수) {
        var visited = new boolean[대륙수][N][N]; // 대륙별로 따로 방문 관리해야 한다
        var queue = new ArrayDeque<int[]>();
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c) // 모든 육지 칸을 출발지로 등록한다
                if (map[r][c] != '0') queue.add(new int[] {r, c, 0, map[r][c]});
        while (queue.size() > 0) {
            int[] p = queue.remove();
            int r = p[0], c = p[1], distance = p[2], no = p[3];
            if (r < 0 || r >= N || c < 0 || c >= N) continue;
            if (map[r][c] != '0' && map[r][c] != no) return distance; // 다른 대륙 발견
            if (map[r][c] != '0' && distance > 1) continue; // 바다가 아닌 곳은 출발지 뿐이어야
            if (visited[no-'2'][r][c]) continue; // 대륙별로 따로 방문 관리
            visited[no-'2'][r][c] = true;        // 대륙 no 최소값은 '2'
            queue.add(new int[] {r-1, c, distance+1, no});
            queue.add(new int[] {r+1, c, distance+1, no});
            queue.add(new int[] {r, c-1, distance+1, no});
            queue.add(new int[] {r, c+1, distance+1, no});
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        map = new char[N][];
        for (int r = 0; r < N; ++r)
            map[r] = reader.readLine().replaceAll(" ", "").toCharArray();

        // 대륙의 문자를 '2', '3', '4'... 로 바꾼다.
        char no = '1';
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                if (map[r][c] == '1') DFS(r, c, '1', ++no);
        int 대륙수 = no - '2' + 1;
        System.out.println(BFS(대륙수) - 1);
    }
}