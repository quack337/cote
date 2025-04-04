package baekjoon.b11.p11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; ++t) {
            int N = Integer.parseInt(reader.readLine());
            int[][] DP크기 = new int[N][N];
            int[][] DP비용 = new int[N][N];
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < N; ++i)
                DP크기[i][i] = Integer.parseInt(tokenizer.nextToken());
            for (int d = 1; d < N; ++d) {
                for (int i = 0; i < N - d; ++i) {
                    int 최소비용 = Integer.MAX_VALUE;
                    DP크기[i][i+d] = DP크기[i][i] + DP크기[i+1][i+d];
                    for (int m = 0; m < d; ++m) {
                        int 비용 = DP비용[i][i+m] + DP비용[i+m+1][i+d] + DP크기[i][i+d];
                        if (비용 < 최소비용) 최소비용 = 비용;
                    }
                    DP비용[i][i+d] = 최소비용;
                }
            }
            System.out.println(DP비용[0][N-1]);
        }
    }
}