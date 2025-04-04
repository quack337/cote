package baekjoon.b01.b1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());
        reader.close();;

        int[] 합 = new int[N];
        int 최대 = A[0];
        합[0] = A[0];
        for (int i = 1; i < N; ++i) {
            if (A[i] > 최대) 최대 = A[i];
            합[i] = Math.max(A[i-1] + A[i], 합[i-1] + A[i]);
            if (합[i] > 최대) 최대 = 합[i];
        }
        System.out.println(최대);
    }
}