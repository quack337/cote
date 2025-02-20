package baekjoon.p02.p2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int sum(int[] A, int max) {
        int result = 0;
        for (int i : A)
            result += Math.min(i, max);
        return result;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] A = new int[N];
        int max = 0;
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(tokenizer.nextToken());
            if (A[i] > max) max = A[i];
        }
        int M = Integer.parseInt(reader.readLine());

        int start = 0, end = max, answer = 0;
        while (start <= end) {
            int middle = (start + end) / 2;
            int m = sum(A, middle);
            if (m <= M) {
                start = middle + 1;
                answer = middle;
            } else
                end = middle - 1;
        }
        System.out.println(answer);
    }
}
