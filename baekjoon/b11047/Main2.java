package baekjoon.b11047;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    static int INFINITY = 100000000;
    static int[] A;
    static int[] DP;

    static int 최소수(int k) {
        if (k == 0) return 0;
        if (DP[k] > -1) return DP[k];
        int min = INFINITY;
        for (int i = 0; i < A.length; ++i)
            if (k >= A[i]) {
                int count = 1 + 최소수(k - A[i]);
                if (count < min) min = count;
            }
        return DP[k] = min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        A = new int[N];
        DP = new int[K + 1];
        Arrays.fill(DP, -1);
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(reader.readLine());
        System.out.println(최소수(K));
    }
}