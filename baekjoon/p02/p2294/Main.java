package baekjoon.p02.p2294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static final int MAX = 100000;
    static int[] A;

    static int 최소동전수(int K) {
        int[] DP = new int[K+1];
        Arrays.fill(DP, MAX);
        DP[0] = 0;
        for (int i = 1; i <= K; ++i)
            for (int j = 0; j < A.length; ++j) {
                int k = i - A[j];
                if (k >= 0)
                    DP[i] = Math.min(DP[i], DP[k] + 1);
            }
        return DP[K] == MAX ? -1 : DP[K];
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        TreeSet<Integer> set = new TreeSet<>(); // 중복 동전 제거하기
        for (int i = 0; i < N; ++i)
            set.add(Integer.parseInt(reader.readLine()));
        A = new int[set.size()];
        int index = 0;
        for (int a : set)
            A[index++] = a;
        System.out.println(최소동전수(K));
    }
}
