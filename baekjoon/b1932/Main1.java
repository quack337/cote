package baekjoon.b1932;
import java.util.Scanner;

public class Main1 {
    static int[][] A;

    static int sum(int i, int j) {
        if (i >= A.length) return 0;
        System.out.printf("%d, %d\n", i, j);
        return A[i][j] + Math.max(sum(i+1, j), sum(i+1, j+1));
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int DEPTH = scanner.nextInt();
            A = new int[DEPTH][];
            for (int i = 0; i < DEPTH; ++i) {
                A[i] = new int[i + 1];
                for (int j = 0; j <= i; ++j)
                    A[i][j] = scanner.nextInt();
            }
            System.out.println(sum(0, 0));
        }
    }
}