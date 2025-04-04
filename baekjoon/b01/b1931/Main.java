package baekjoon.b01.b1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int START = 0, END = 1;

    static boolean overlap(int[] a, int[] b) {
        if (a[END] <= b[START]) return false;
        if (a[START] >= b[END]) return false;
        return true;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[][] A = new int[N][2];
        for (int i = 0; i < N; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            A[i][START] = Integer.parseInt(tokenizer.nextToken());
            A[i][END] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(A, (a, b) ->  a[END] - b[END]);

        int count = 0;
        int[] previous = null;
        for (int[] a : A)
            if (previous == null || overlap(a, previous) == false) {
                ++count;
                previous = a;
            }
        System.out.println(count);
    }
}