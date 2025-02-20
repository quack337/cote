package baekjoon.p02.p2293;

import java.util.Scanner;

public class Main {
    static int 경우의수_찾기(int[] 동전목록, int 목표금액) {
        int[] 경우의수 = new int[목표금액+1];
        경우의수[0] = 1;
        for (int 동전가치 : 동전목록)
            for (int 금액 = 동전가치; 금액 <= 목표금액; ++금액)
                경우의수[금액] += 경우의수[금액 - 동전가치];
        return 경우의수[목표금액];
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[] 동전목록 = new int[N];
            for (int i = 0; i < N; ++i)
                동전목록[i] = scanner.nextInt();
            System.out.println(경우의수_찾기(동전목록, K));
        }
    }
}
