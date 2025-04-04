package baekjoon.b01.b1011;

public class Main2 {

    static int 탐색1(int 남은거리, int 직전이동거리, int 이동수) {
        if (남은거리 == 0 && 직전이동거리 == 1) return 이동수;
        if ((남은거리 == 0 && 직전이동거리 != 1) ||남은거리 < 0 ) return Integer.MAX_VALUE;

        int 최소 = Integer.MAX_VALUE;
        for (int i = -1; i <= 1; ++i) {
            int 이동거리 = 직전이동거리 + i;
            if (이동거리 > 0) {
                int r = 탐색1(남은거리 - 이동거리, 이동거리, 이동수 + 1);
                if (r < 최소) 최소 = r;
            }
        }
        return 최소;
    }

    static int 탐색2(int 거리) {
        int n = (int)Math.sqrt(거리);
        if (거리 == n*n) return 2*n - 1;
        if (n*n < 거리 && 거리 <= n*n+n) return 2*n;
        return 2*n + 1;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 40; ++i) {
            int n2 = 탐색2(i);
            int n1 = 탐색1(i, 0, 0);
            System.out.printf("%d %d %d\n", i, n1, n2);
            if (n1 != n2) System.out.println("에러");
        }
        System.out.println("done");
    }
}