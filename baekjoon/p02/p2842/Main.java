package baekjoon.p02.p2842;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int[][] D = {{-1,-1}, {-1,0}, {-1,+1}, {0,-1}, {0,+1}, {+1,-1}, {+1,0}, {+1,+1}};
    static int N;
    static char[][] map;
    static int[][] height;
    static boolean[][] visited;
    static int maxHeight, minHeight;  // 방문할 최대 높이, 최소 높이
    static int r0, c0;                // 시작 위치
    static int houseCount;            // 방문할 집의 수

    static int DFS(int r, int c) {
        if (visited[r][c]) return 0;
        visited[r][c] = true;
        if (height[r][c] < minHeight || height[r][c] > maxHeight) return 0;
        int count = 0;
        if (map[r][c] == 'K') count = 1;
        for (int[] d : D) {
            int r1 = r + d[0], c1 = c + d[1];
            if (r1 < 0 || r1 >= N) continue;
            if (c1 < 0 || c1 >= N) continue;
            if (visited[r1][c1]) continue;
            count += DFS(r1, c1);
        }
        return count;
    }

    static int DFS() {
        visited = new boolean[N][N];
        return DFS(r0, c0);
    }

    static void bsearchMax() { // 이진 탐색으로 방문할 최대 높이를 찾는다
        int start = minHeight, end = 1000000, answer = 0;
        while (start <= end) {
            int middle = (start + end) / 2;
            maxHeight = middle;
            int count = DFS();
            if (count >= houseCount) {
                end = middle - 1;
                answer = middle;
            } else
                start = middle + 1;
        }
        maxHeight = answer;
    }

    static void bsearchMin() { // 이진 탐색으로 방문할 최소 높이를 찾는다
        int start = 1, end = maxHeight, answer = 0;
        while (start <= end) {
            int middle = (start + end) / 2;
            minHeight = middle;
            int count = DFS();
            if (count >= houseCount) {
                start = middle + 1;
                answer = middle;
            } else
                end = middle - 1;
        }
        minHeight = answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        map = new char[N][];
        height = new int[N][N];
        houseCount = 0;
        for (int r = 0; r < N; ++r) {
            map[r] = reader.readLine().toCharArray();
            for (int c = 0; c < N; ++c)
                if (map[r][c] == 'P') { r0 = r; c0 = c; } // 시작 위치
                else if (map[r][c] == 'K') ++houseCount;  // 방문할 집
        }
        for (int r = 0; r < N; ++r) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 0; c < N; ++c)
                height[r][c] = Integer.parseInt(tokenizer.nextToken());
        }
        minHeight = maxHeight = 1;
        int minDifference = Integer.MAX_VALUE;
        while (true) {
            bsearchMax(); bsearchMin();
            if (DFS() < houseCount) break;
            minDifference = Math.min(minDifference, maxHeight - minHeight);
            ++minHeight;
        }
        System.out.println(minDifference);
    }
}