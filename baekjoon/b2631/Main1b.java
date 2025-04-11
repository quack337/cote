package baekjoon.b2631;
import java.util.Scanner;

public class Main1b {

    static int sol(int[] a, int index, int max, int length) {
        if (index >= a.length) return length;
        int length1 = 0, length2 = 0;
        length1 = sol(a, index + 1, max, length);

        if (a[index] > max)
            length2 = sol(a, index + 1, a[index], length + 1);
        return Math.max(length1, length2);
    }

    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; ++i)
                A[i] = scanner.nextInt();
            int length = sol(A, 0, 0, 0);
            System.out.println(N - length);
        }
    }
}