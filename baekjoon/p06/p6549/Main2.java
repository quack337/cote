package baekjoon.p06.p6549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int[] A;

    static int 최소높이_위치(int start, int end) {
        int minValue = A[start], minIndex = start;
        for (int i = start + 1; i <= end; ++i)
            if (A[i] < minValue) {
                minValue = A[i];
                minIndex = i;
            }
        return minIndex;
    }

    static long 최대면적찾기(int start, int end) {
        if (start > end) return 0;
        if (start == end) return A[start];
        int index = 최소높이_위치(start, end);
        long 면적 = (long)A[index] * (end - start + 1);
        long 면적1 = 최대면적찾기(start, index - 1);
        long 면적2 = 최대면적찾기(index + 1, end);
        return Math.max(면적, Math.max(면적1, 면적2));
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
            System.out.println(최대면적찾기(0, A.length-1));
        }
        reader.close();
    }
}
