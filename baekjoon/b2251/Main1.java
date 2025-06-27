package baekjoon.b2251;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {

    static final int MAX = 200;
    static boolean[][][] visited = new boolean[MAX+1][MAX+1][MAX+1];
    static int[] 물통용량;

    static void DFS(int[] 물통) {
        int a = 물통[0], b = 물통[1], c = 물통[2];
        if (visited[a][b][c]) return;
        visited[a][b][c] = true;
        for (int from = 0; from < 3; ++from)
            for (int to = 0; to < 3; ++to) {
                if (from == to) continue;
                if (물통[from] == 0) continue;
                if (물통[to] == 물통용량[to]) continue;
                int water = Math.min(물통[from], 물통용량[to] - 물통[to]); // 옮길 물의 양
                물통[from] -= water; 물통[to] += water; // 물 옮기기
                DFS(물통);
                물통[from] += water; 물통[to] -= water; // 물 옮기기 취소
            }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int A = Integer.parseInt(tokenizer.nextToken());
        int B = Integer.parseInt(tokenizer.nextToken());
        int C = Integer.parseInt(tokenizer.nextToken());
        물통용량 = new int[] {A, B, C};
        DFS(new int[] {0, 0, C});
        StringBuilder builder = new StringBuilder();
        for (int c = 0; c <= MAX; ++c)
            for (int b = 0; b <= MAX; ++b)
                if (visited[0][b][c]) {
                    builder.append(c).append(' ');
                    break;
                }
        System.out.println(builder.toString());
    }
}