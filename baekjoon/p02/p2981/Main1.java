package baekjoon.p02.p2981;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    static int 최대공약수(int a, int b){
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; ++i)
                A[i] = scanner.nextInt();
            Arrays.sort(A);
            for (int i = 1; i < N; ++i)
                A[i-1] = A[i] - A[i-1];

            int gcd = A[0];
            for (int i = 0; i < N-2; ++i) {
                int g = 최대공약수(A[i], A[i+1]);
                if (g < gcd) gcd = g;
            }
            for (int i = 2; i <= gcd/2; ++i)
                if (gcd % i == 0)
                    System.out.printf("%d ", i);
            System.out.println(gcd);
        }
    }
}
