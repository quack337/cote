package baekjoon.b2565;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int N = 501;
    static int[] A;
    static int[][] DP;

    static int 오름차순_최대길이(int index, int previous) {
        if (index >= N) return 0;
        if (DP[index][previous] > -1) return DP[index][previous];
        int r1 = 0, r2 = 0;
        if (A[index] > previous) r1 = 1 + 오름차순_최대길이(index + 1, A[index]);
        r2 = 오름차순_최대길이(index + 1, previous);
        return DP[index][previous] = Math.max(r1, r2);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        A = new int[N];
        DP = new int[N][N];
        for (int i = 0; i < N; ++i)
            Arrays.fill(DP[i], -1);
        int 전기줄수 = Integer.parseInt(reader.readLine());
        for (int i = 0; i < 전기줄수; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            A[a] = b;
        }
        System.out.println(전기줄수 - 오름차순_최대길이(1, 0));
    }
}