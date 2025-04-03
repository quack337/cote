package baekjoon.p01.p1405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    static int[][] D = new int[][] {{+1,0}, {-1,0}, {0,+1}, {0,-1}};
    static final int MAX = 14;
    static int 최대이동횟수;
    static double[] 확률 = new double[4];

    static double 이동확률계산(int[] 방향) {
        double result = 1;
        for (int d : 방향)
            result *= 확률[d];
        return result;
    }

    static double DFS(int x, int y, int[] 이동방향, int index, boolean[][] visited) {
        if (visited[x+MAX][y+MAX]) return 0;                      // 단순하지 않은 경로, 0을 리턴
        if (index == 최대이동횟수) return 이동확률계산(이동방향); // 단순경로, 이 경로의 확률 리턴
        visited[x+MAX][y+MAX] = true;
        double 확률합계 = 0; // 단순경로 확률 합계
        for (int d = 0; d < 4; ++d) {
            이동방향[index] = d;
            확률합계 += DFS(x + D[d][0], y + D[d][1], 이동방향, index + 1, visited);
        }
        visited[x+MAX][y+MAX] = false;
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
        System.out.println(DFS(0, 0, new int[최대이동횟수], 0, new boolean[MAX*2+1][MAX*2+1]));
    }
}