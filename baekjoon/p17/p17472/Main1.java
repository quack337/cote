package baekjoon.p17.p17472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1 {
    static int INF = 1_000_000_000;
    static int R, C, N; // R: 행의 수, C: 열의 수, N: 섬의 수
    static int[][] map;
    static int[][] distances; // 섬 사이 최단거리

    static void DFS1(int r, int c, int id) { // 섬의 id를 기록한다. id는 2, 3, 4,...
        if (r < 0 || c < 0 || r >= R || c >= C) return ;
        if (map[r][c] != 1) return;
        map[r][c] = id;
        DFS1(r-1, c, id);
        DFS1(r+1, c, id);
        DFS1(r, c-1, id);
        DFS1(r, c+1, id);
    }

    static void DFS2(int r, int c, int startId, int dir, int distance) { // 섬 사이 최단거리 찾기
        if (r < 0 || c < 0 || r >= R || c >= C) return;
        if (distance > 0 && map[r][c] != 0) {
            if (map[r][c] == startId) return;
            int endId = map[r][c];
            --distance;
            if (distance != 1 && distance < distances[startId-2][endId-2])
                distances[startId-2][endId-2] = distance;
            return;
        }
        switch (dir) {
        case 0: DFS2(r-1, c, startId, dir, distance + 1); break;
        case 1: DFS2(r, c+1, startId, dir, distance + 1); break;
        case 2: DFS2(r+1, c, startId, dir, distance + 1); break;
        case 3: DFS2(r, c-1, startId, dir, distance + 1); break;
        }
    }

    static int prim() { // 최소 신장 트리 프림 알고리즘
        var queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        var visited = new boolean[N];
        queue.add(new int[] {0, 0});
        int result = 0;
        while (queue.size() > 0) {
            int[] edge = queue.remove();
            int node = edge[0], cost = edge[1];
            if (visited[node]) continue;
            visited[node] = true;
            result += cost;
            for (int next = 0; next < N; ++next)
                if (visited[next] == false && distances[node][next] < INF)
                    queue.add(new int[] { next, distances[node][next] });
        }
        for (var v : visited) if (v == false) return -1;
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        map = new int[R][C];
        for (int r = 0; r < R; ++r) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 0; c < C; ++c)
                map[r][c] = Integer.parseInt(tokenizer.nextToken());
        }
        int id = 2;
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c)
                if (map[r][c] == 1)
                    DFS1(r, c, id++);
        N = id - 2;
        distances = new int[N][N];
        for (var d : distances) Arrays.fill(d, INF);
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c)
                if (map[r][c] != 0)
                    for (int dir = 0; dir < 4; ++dir)
                        DFS2(r, c, map[r][c], dir, 0);
        System.out.println(prim());
    }
}
