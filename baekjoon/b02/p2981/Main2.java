package baekjoon.b02.p2981;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {
    static int 최대공약수(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(reader.readLine());
        Arrays.sort(A);
        for (int i = 1; i < N; ++i)
            A[i - 1] = A[i] - A[i - 1];

        int gcd = A[0];
        for (int i = 0; i < N - 2; ++i) {
            int g = 최대공약수(A[i], A[i + 1]);
            if (g < gcd)
                gcd = g;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 2; i <= gcd / 2; ++i)
            if (gcd % i == 0)
                builder.append(i).append(' ');
        builder.append(gcd);
        System.out.println(builder.toString());
    }
}