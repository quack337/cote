package baekjoon.p06.p6549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    static int[] A;

    static int 최소높이(int start, int end) {
        int min = A[start];
        for (int i = start + 1; i <= end; ++i)
            if (A[i] < min) min = A[i];
        return min;
    }

    static long 최대면적찾기() {
        int N = A.length;
        long 최대면적 = 0;
        for (int 폭 = 1; 폭 <= N; ++폭)
            for (int i = 0; i <= N - 폭; ++i) {
                long 높이 = 최소높이(i, i + 폭 - 1);
                long 면적 = 높이 * 폭;
                if (면적 > 최대면적) 최대면적 = 면적;
            }
        return 최대면적;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(tokenizer.nextToken());
            if (N == 0) break;
            A = new int[N];
            for (int i = 0; i < N; ++i)
                A[i] = Integer.parseInt(tokenizer.nextToken());
            System.out.println(최대면적찾기());
        }
        reader.close();
    }
}