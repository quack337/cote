package baekjoon.p17.p17435;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main3 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(reader.readLine());
        int N = (int)(Math.log(500_0000) / Math.log(2));
        var DP = new int[M + 1][N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int x = 1; x <= M; ++x)
            DP[x][0] = Integer.parseInt(tokenizer.nextToken());
        for (int n = 1; n < N; ++n)
            for (int x = 1; x <= M; ++x) {
                int x2 = DP[x][n - 1];
                DP[x][n] = DP[x2][n - 1];
            }
        int Q = Integer.parseInt(reader.readLine());
        for (int q = 0; q < Q; ++q) {
            tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int x = Integer.parseInt(tokenizer.nextToken());
            for (int i = 0; i < N; ++i) {
                int bit = (n >> i) & 1;
                if (bit == 1) x = DP[x][i];
            }
            writer.write(x + "\n");
        }
        reader.close(); writer.close();
    }
}