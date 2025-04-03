package baekjoon.p01.p1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());
        reader.close();;

        int[] 합 = new int[N];
        int 최대 = Integer.MIN_VALUE;
        for (int d = 0; d < N; ++d)
            for (int i = 0; i < N-d; ++i) {
                합[i+d] += A[i];
                if (합[i+d] > 최대) 최대 = 합[i+d];
            }
        System.out.println(최대);
    }
}