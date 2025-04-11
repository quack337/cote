package baekjoon.b9184;
import java.util.Scanner;

public class Main2 {

    static int[][][] DP = new int[101][101][101];

    static int w(int a, int b, int c) {
        if (DP[a+50][b+50][c+50] > 0) return DP[a+50][b+50][c+50];
        if (a <= 0 || b <= 0 || c <= 0)
            return DP[a+50][b+50][c+50] = 1;
        if (a > 20 || b > 20 || c > 20)
            return DP[a+50][b+50][c+50] = w(20, 20, 20);
        if (a < b && b < c)
            return DP[a+50][b+50][c+50] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        return DP[a+50][b+50][c+50] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (a == -1 && b == -1 && c == -1) break;
            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
        }
        scanner.close();
    }
}