package baekjoon.b9084;
import java.util.Scanner;

public class Main3 {

    static int sol(int 목표금액, int[] 동전목록) {
        System.out.println(목표금액);
        if (목표금액 == 0) return 1;
        int count = 0;
        for (int i = 0; i < 동전목록.length; ++i)
            if (목표금액 >= 동전목록[i])
                count += sol(목표금액 - 동전목록[i], 동전목록);
        return count;
    }

    static void sol(int[] 동전목록, int 금액) {
        int count = sol(금액, 동전목록);
        System.out.println(count);
    }

    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            int T = scanner.nextInt();
            for (int t = 0; t < T; ++t) {
                int N = scanner.nextInt();
                int[] 동전목록 = new int[N];
                for (int i = 0; i < N; ++i)
                    동전목록[i] = scanner.nextInt();
                int 금액 = scanner.nextInt();
                sol(동전목록, 금액);
            }
        }
    }
}