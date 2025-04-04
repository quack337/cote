package baekjoon.b10.p10811;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; ++i)
            A[i] = i + 1;
        for (int i = 0; i < M; ++i) {
            int from = scanner.nextInt() - 1;
            int to = scanner.nextInt() - 1;
            // from ~ to 영역 뒤집기
            while (from < to) {
              int temp = A[from];
              A[from] = A[to];
              A[to] = temp;
              ++from; --to;
            }
        }
        for (int i = 0; i < N; ++i)
            System.out.print(A[i] + " ");
        scanner.close();
    }
}