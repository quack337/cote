package baekjoon.b10.p10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] A = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());
        Arrays.sort(A);
        int M = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < M; ++i) {
            int a = Integer.parseInt(tokenizer.nextToken());
            int index = Arrays.binarySearch(A, a);
            if (index < 0) builder.append(0).append(' ');
            else {
                int start = index, end = index;
                while (start >= 0 && A[start] == a) --start;
                while (end < A.length && A[end] == a) ++end;
                builder.append(end - start - 1).append(' ' );
            }
        }
        System.out.println(builder.toString());
    }
}