package baekjoon.b2293.old;
import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    static int[] 동전;

    static int 경우의수_찾기(int 동전_인덱스, int 남은금액) {
        if (남은금액 == 0) return 1;
        int 동전가치 = 동전[동전_인덱스];
        if (동전_인덱스 == 동전.length-1)
            return 남은금액 % 동전가치 == 0 ? 1 : 0;

        int 경우의수 = 0;
        int 최대동전수 = 남은금액 / 동전가치;
        for (int 동전수 = 0; 동전수 <= 최대동전수; ++동전수)
            경우의수 += 경우의수_찾기(동전_인덱스 + 1, 남은금액 - 동전가치 * 동전수);
        return 경우의수;
    }

    static void reverse(int[] a) {
        for (int i = 0, j = a.length - 1; i < j; ++i, --j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            동전 = new int[N];
            for (int i = 0; i < N; ++i)
                동전[i] = scanner.nextInt();
            Arrays.sort(동전);
            reverse(동전); // 내림차순으로 정렬
            System.out.println(경우의수_찾기(0, K));
        }
    }
}