package baekjoon.p10.p10986;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
      public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        var tokennizer = new StringTokenizer(s);
        int N = Integer.parseInt(tokennizer.nextToken());;
        int M = Integer.parseInt(tokennizer.nextToken());;
        int[] A = new int[N];
        s = reader.readLine();
        tokennizer = new StringTokenizer(s);
        for (int i = 0; i < N; ++i)
            A[i] = (int)(Long.parseLong(tokennizer.nextToken()) % M);
        int[] S = new int[N];
        S[0] = A[0] % M;
        for (int i = 1; i < N; ++i)
            S[i] = (S[i - 1] + A[i]) % M;
        int[] C = new int[M];
        for (int i : S)
            C[i]++;
        long answer = C[0];
        for (int i = 1; i < N; ++i)
            answer += --C[S[i - 1]];
        System.out.println(answer);
        reader.close();
    }
}