package baekjoon.p11.p11052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] P;
    static int[] DP;

    static int 최대금액(int 카드수) {
        if (카드수 == 0) return 0;
        if (DP[카드수] > 0) return DP[카드수];
        int 최대값 = 0;
        for (int i = 1; i <= 카드수; ++i) {
            int 카드팩_카드수 = i;
            int 카드팩_가격 = P[i];
            int 금액 = 카드팩_가격 + 최대금액(카드수 - 카드팩_카드수);
            if (금액 > 최대값) 최대값 = 금액;
        }
        return DP[카드수] = 최대값;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        P = new int[N + 1];
        DP = new int[N + 1];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= N; ++i)
            P[i] = Integer.parseInt(tokenizer.nextToken());
        System.out.println(최대금액(N));
    }
}