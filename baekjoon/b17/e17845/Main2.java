package baekjoon.b17.e17845;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    static int 과목수;
    static int[] 중요도목록, 공부시간목록;
    static int[][] DP = new int[1001][10001];

    static int 완전탐색(int index, int 남은공부시간) {
        if (DP[index][남은공부시간] != -1) return DP[index][남은공부시간];
        if (남은공부시간 == 0 || index == 과목수) return 0;

        int 중요도1 = 0, 중요도2 = 0;
        중요도1 = 완전탐색(index + 1, 남은공부시간);

        if (남은공부시간 >= 공부시간목록[index])
            중요도2 = 중요도목록[index] +
                      완전탐색(index + 1, 남은공부시간 - 공부시간목록[index]);

        return DP[index][남은공부시간] = Math.max(중요도1, 중요도2);
    }

    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            for (int i = 0; i < DP.length; ++i)
                Arrays.fill(DP[i], -1);
            int 최대공부시간 = scanner.nextInt();
            과목수 = scanner.nextInt();
            중요도목록 = new int[과목수];
            공부시간목록 = new int[과목수];
            for (int k = 0; k < 과목수; ++k) {
                중요도목록[k] = scanner.nextInt();
                공부시간목록[k] = scanner.nextInt();
            }
            System.out.println(완전탐색(0, 최대공부시간));
        }
    }

}