package baekjoon.b11.p11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    static int[] A;
    static int N;

    static int 왼쪽_최대길이(int index, int previous) {
        if (index < 0) return 0;
        int r1 = 0, r2 = 0;
        if (A[index] < previous) r1 = 1 + 왼쪽_최대길이(index - 1, A[index]);
        r2 = 왼쪽_최대길이(index - 1, previous);
        return Math.max(r1, r2);
    }

    static int 오른쪽_최대길이(int index, int previous) {
        if (index >= N) return 0;
        int r1 = 0, r2 = 0;
        if (A[index] < previous) r1 = 1 + 오른쪽_최대길이(index + 1, A[index]);
        r2 = 오른쪽_최대길이(index + 1, previous);
        return Math.max(r1, r2);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        A = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());
        int max = 0;
        for (int i = 0; i < N; ++i)
            max = Math.max(max, 1 + 왼쪽_최대길이(i-1, A[i]) + 오른쪽_최대길이(i+1, A[i]));
        System.out.println(max);
    }
}