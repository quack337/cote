package baekjoon.b12852;
import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    static int[] DP;

    static int solution(int x) {
        if (DP[x] != Integer.MAX_VALUE) return DP[x];
        if (x == 1) return DP[x] = 0;
        int r2 = Integer.MAX_VALUE, r3  = Integer.MAX_VALUE;
        int r1 = 1 + solution(x - 1);
        if (x % 3 == 0) r3 = 1 + solution(x / 3);
        if (x % 2 == 0) r2 = 1 + solution(x / 2);
        return DP[x] = Math.min(r1, Math.min(r2, r3));
    }

    static void print(int x) {
        if (x == 1) {
            System.out.println(1);
            return;
        }
        System.out.print(x + " ");
        int y = x - 1;
        if (x % 3 == 0 && DP[x / 3] < DP[y]) y = x / 3;
        if (x % 2 == 0 && DP[x / 2] < DP[y]) y = x / 2;
        print(y);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int x = scanner.nextInt();
            DP = new int[x + 1];
            Arrays.fill(DP, Integer.MAX_VALUE);
            System.out.println(solution(x));
            print(x);
        }
    }
}