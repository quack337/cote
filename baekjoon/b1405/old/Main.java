package baekjoon.b1405.old;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] D = new int[][] {{+1,0}, {-1,0}, {0,+1}, {0,-1}};
    static int 최대이동횟수;
    static double[] 확률 = new double[4];

    static double DFS(int x, int y, double 이동확률, int index, boolean[][] visited) {
        if (visited[x][y]) return 0;                   // 단순하지 않은 경로, 0을 리턴
        if (index == 최대이동횟수) return 이동확률;    // 단순경로, 이 경로의 확률 리턴
        visited[x][y] = true;
        double 확률합계 = 0; // 단순경로 확률 합계
        for (int d = 0; d < 4; ++d)
            확률합계 += DFS(x + D[d][0], y + D[d][1], 이동확률 * 확률[d], index + 1, visited);
        visited[x][y] = false;
        return 확률합계;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        최대이동횟수 = Integer.parseInt(tokenizer.nextToken());
        확률[0] = Integer.parseInt(tokenizer.nextToken()) / 100.0;
        확률[1] = Integer.parseInt(tokenizer.nextToken()) / 100.0;
        확률[2] = Integer.parseInt(tokenizer.nextToken()) / 100.0;
        확률[3] = Integer.parseInt(tokenizer.nextToken()) / 100.0;
        System.out.println(DFS(14, 14, 1, 0, new boolean[14*2+1][14*2+1]));
    }
}