package baekjoon.p01.p1940;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        int[] A = new int[N];
        String s = reader.readLine();
        var tokennizer = new StringTokenizer(s);
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokennizer.nextToken());
        reader.close();
        Arrays.sort(A);

        int i1 = 0, i2 = A.length - 1, answer = 0;
        while (i1 < i2) {
            int value = A[i1] + A[i2];
            if (value == M) {
                ++answer;
                ++i1;
                --i2;
            } else if (value < M)
                ++i1;
            else if (value > M)
                --i2;
        }
        System.out.println(answer);
    }
}
