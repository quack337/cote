package baekjoon.b14889.old;
import java.util.Scanner;

public class Main {

    static int[][] 능력치;

    static int 능력치합계(int[] 팀) {
        int 합계 = 0;
        for (int 선수1 : 팀)
            for (int 선수2 : 팀)
                합계 += 능력치[선수1][선수2];
        return 합계;
    }

    static int 계산(int[] 팀1, int 인덱스1, int[] 팀2, int 인덱스2, int 선수) {
        if (선수 < 0)
            return Math.abs(능력치합계(팀1) - 능력치합계(팀2));
        int 능력치차이1 = Integer.MAX_VALUE, 능력치차이2 = Integer.MAX_VALUE;
        if (인덱스1 < 팀1.length) {
            팀1[인덱스1] = 선수;
            능력치차이1 = 계산(팀1, 인덱스1+1, 팀2, 인덱스2, 선수-1);
        }
        if (인덱스2 < 팀2.length) {
            팀2[인덱스2] = 선수;
            능력치차이2 = 계산(팀1, 인덱스1, 팀2, 인덱스2+1, 선수-1);
        }
        return Math.min(능력치차이1, 능력치차이2);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            능력치 = new int[N][];
            for (int r = 0; r < N; ++r) {
                능력치[r] = new int[N];
                for (int c = 0; c < N; ++c)
                    능력치[r][c] = scanner.nextInt();
            }
            System.out.println(계산(new int[N/2], 0, new int[N/2], 0, N - 1));
        }
    }
}