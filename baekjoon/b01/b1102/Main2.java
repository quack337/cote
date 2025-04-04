package baekjoon.b01.b1102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static final int INF = 1_000_000_000;
    static int N, P;
    static int[][] cost;
    static Integer[][] DP;

    static int sol(int P, int state) {
        if (P <= 0) return 0;
        if (DP[P][state] != null) return DP[P][state];
        int result = INF;
        for (int a = 0; a < N; ++a)
            if ((state & (1 << a)) != 0)
                for (int b = 0; b < N; ++b)
                    if ((state & (1 << b)) == 0)
                        result = Math.min(result, cost[a][b] + sol(P - 1, state | (1 << b)));
        return DP[P][state] = result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        cost = new int[N][N];
        for (int r = 0; r < N; ++r) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 0; c < N; ++c)
                cost[r][c] = Integer.parseInt(tokenizer.nextToken());
        }
        char[] states = reader.readLine().toCharArray();
        P = Integer.parseInt(reader.readLine());
        int state = 0;
        for (int i = 0; i < states.length; ++i)
            if (states[i] == 'Y') {
                state |= (1 << i);
                --P;
            }
        DP = new Integer[P+1][2 << N];
        int answer = sol(P, state);
        System.out.println(answer == INF ? -1 : answer);
    }
}