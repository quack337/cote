package baekjoon.p10.p10807;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; ++i)
            A[i] = scanner.nextInt();
        int v = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < N; ++i)
            if (v == A[i]) ++count;
        System.out.println(count);
        scanner.close();
    }
}
