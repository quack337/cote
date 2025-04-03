package baekjoon.p02.p2294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1 {
    static int[] A;
    static int[] DP;

    static int 최소동전수(int k) {
        if (k == 0) return 0;
        if (DP[k] > -1) return DP[k];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; ++i)
            if (A[i] <= k) {
                int count = 1 + 최소동전수(k - A[i]);
                if (count < min) min = count;
            }
        return DP[k] = min;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        DP = new int[K+1];
        Arrays.fill(DP, -1);
        A = new int[N];
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(reader.readLine());
        System.out.println(최소동전수(K));
    }
}