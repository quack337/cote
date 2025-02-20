package baekjoon.p11.p11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] A;
    static int[][] DP;

    static int 탐색(int index, int previous) {
        if (index >= A.length) return 0;
        if (DP[index][previous] >= 0) return DP[index][previous];

        int count1 = 0, count2 = 0;
        if (A[index] > previous) count1 = 1 + 탐색(index + 1, A[index]);
        count2 = 탐색(index + 1, previous);
        return DP[index][previous] = Math.max(count1, count2);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        A = new int[N];
        DP = new int[N][1001];
        for (int i = 0; i < N; ++i)
            Arrays.fill(DP[i], -1);
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());
        System.out.println(탐색(0, 0));
    }
}
