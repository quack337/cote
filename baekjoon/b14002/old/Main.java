package baekjoon.b14002.old;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MAX_VALUE = 1000;
    static int N;
    static int[][] DP;
    static int[] A;

    static int 증가부분수열_최대길이(int index, int previous) {
        if (index >= N) return 0;
        if (DP[index][previous] > -1) return DP[index][previous];
        int r1 = 0, r2 = 0;
        if (A[index] > previous) r1 = 1 + 증가부분수열_최대길이(index + 1, A[index]);
        r2 = 증가부분수열_최대길이(index + 1, previous);
        return DP[index][previous] = Math.max(r1, r2);
    }

    static void 최대부분수열(StringBuilder builder) {
        int previous = 0;
        for (int i = 0; i < N-1; ++i) {
            if (DP[i][previous] == 1 + DP[i+1][A[i]]) {
                builder.append(A[i]).append(' ');
                previous = A[i];
            }
        }
        int i = N-1;
        if (DP[i][previous] == 1)
            builder.append(A[i]).append(' ');
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        A = new int[N];
        DP = new int[N][MAX_VALUE+1];
        for (int i = 0; i < N; ++i)
            Arrays.fill(DP[i], -1);
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());
        StringBuilder builder = new StringBuilder();
        int 길이 = 증가부분수열_최대길이(0, 0);
        builder.append(길이).append('\n');
        최대부분수열(builder);
        System.out.println(builder.toString());
    }
}