package baekjoon.b14923;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main1 {
    static int R, C;   // 행렬 크기
    static int rS, cS; // 시작 위치
    static int rE, cE; // 탈출 위치
    static char[][] map; // 지도

    static int dijkstra() {
        var visited = new boolean[2][R][C];
        var queue = new ArrayDeque<int[]>();
        queue.add(new int[] { rS, cS, 0, 1 });
        while (queue.size() > 0) {
            int[] a = queue.remove();
            int r = a[0], c = a[1], distance = a[2], magic = a[3];
            if (r == rE && c == cE) return distance;
            if (visited[magic][r][c]) continue;
            if (map[r][c] == '1') {
                if (magic > 0) --magic;
                else continue;
            }
            visited[magic][r][c] = true;
            if (r > 0) queue.add(new int[] { r-1, c, distance + 1, magic });
            if (c > 0) queue.add(new int[] { r, c-1, distance + 1, magic });
            if (r < R-1) queue.add(new int[] { r+1, c, distance + 1, magic });
            if (c < C-1) queue.add(new int[] { r, c+1, distance + 1, magic });
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        rS = Integer.parseInt(tokenizer.nextToken()) - 1;
        cS = Integer.parseInt(tokenizer.nextToken()) - 1;
        tokenizer = new StringTokenizer(reader.readLine());
        rE = Integer.parseInt(tokenizer.nextToken()) - 1;
        cE = Integer.parseInt(tokenizer.nextToken()) - 1;
        map = new char[R][C];
        for (int r = 0; r < R; ++r) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 0; c < C; ++c)
                map[r][c] = tokenizer.nextToken().charAt(0);
        }
        System.out.println(dijkstra());
    }
}