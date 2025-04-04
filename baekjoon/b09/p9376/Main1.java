package baekjoon.b09.p9376;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1 {
    static int INF = 100_000_000;
    static int R, C;      // 지도 크기 (행, 열)
    static char[][] map;  // 지도
    static int[][] prisoner; // 두 죄수의 좌표
    static int[][][] dist;
    static int[] min;

    static class Node {
        int id, r, c, cost;
        HashSet<Integer> gateOpened;

        public Node(int id, int r, int c, int cost, HashSet<Integer> gateOpened) {
            this.id = id; this.r = r; this.c = c; this.cost = cost;
            this.gateOpened = gateOpened;
        }
    }

    static void dijkstra() {
        var queue = new PriorityQueue<Node>((a, b) -> a.cost - b.cost);
        queue.add(new Node(0, prisoner[0][0], prisoner[0][1], 0, new HashSet<>()));
        queue.add(new Node(1, prisoner[1][0], prisoner[1][1], 0, new HashSet<>()));
        for (int r = 0; r < R; ++r) {
            queue.add(new Node(2, r, 0, 0, new HashSet<>()));
            queue.add(new Node(2, r, C-1, 0, new HashSet<>()));
        }
        for (int c = 0; c < C; ++c) {
            queue.add(new Node(2, 0, c, 0, new HashSet<>()));
            queue.add(new Node(2, R-1, c, 0, new HashSet<>()));
        }
        while (queue.size() > 0) {
            var node = queue.remove();
            int id = node.id, r = node.r, c = node.c, cost = node.cost;
            var gateOpened = node.gateOpened;
            if (map[r][c] == '*') continue;
            if (map[r][c] == '#' && gateOpened.contains(r*1000 + c) == false) {
                ++cost;
                gateOpened = new HashSet<>(gateOpened);
                gateOpened.add(r*1000 + c);
            }
            if (dist[id][r][c] != INF) continue;
            dist[id][r][c] = cost;
            if (id < 2 && (r == 0 || c == 0 || r == R-1 || c == C-1))
                min[id] = Math.min(min[id], cost);
            if (r > 0 && dist[id][r-1][c] == INF) queue.add(new Node(id, r-1, c, cost, gateOpened));
            if (c > 0 && dist[id][r][c-1] == INF) queue.add(new Node(id, r, c-1, cost, gateOpened));
            if (r < R-1 && dist[id][r+1][c] == INF) queue.add(new Node(id, r+1, c, cost, gateOpened));
            if (c < C-1 && dist[id][r][c+1] == INF) queue.add(new Node(id, r, c+1, cost, gateOpened));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        var builder = new StringBuilder();
        for (int t = 0; t < T; ++t) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            R = Integer.parseInt(tokenizer.nextToken());
            C = Integer.parseInt(tokenizer.nextToken());
            map = new char[R][];
            prisoner = new int[2][];
            dist = new int[3][][];
            min = new int[] { INF, INF, INF };
            int index = 0;
            for (int r = 0; r < R; ++r) {
                map[r] = reader.readLine().toCharArray();
                for (int c = 0; c < C; ++c)
                    if (map[r][c] == '$')
                        prisoner[index++] = new int[] {r, c};
            }
            for (int i = 0; i < 3; ++i) {
                dist[i] = new int[R][C];
                for (int r = 0; r < R; ++r) Arrays.fill(dist[i][r], INF);
            }
            dijkstra();
            for (int r = 0; r < R; ++r)
                for (int c = 0; c < C; ++c) {
                    int dd = dist[0][r][c] + dist[1][r][c] + dist[2][r][c];
                    if (map[r][c] == '#') dd -= 2;
                    if (dd < min[2]) min[2] = dd;
                }
            builder.append(Math.min(min[0] + min[1], min[2]) + "\n");
        }
        System.out.println(builder.toString());
    }
}