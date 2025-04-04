package baekjoon.b01.b1011;

import java.util.ArrayList;
import java.util.List;

public class Main3 {

    static int solution(int 남은거리, int 직전이동거리, int 이동수) {
        if (남은거리 == 0 && 직전이동거리 == 1) return 이동수;
        if ((남은거리 == 0 && 직전이동거리 != 1) ||남은거리 < 0 ) return Integer.MAX_VALUE;

        int 최소 = Integer.MAX_VALUE;
        for (int i = -1; i <= 1; ++i) {
            int 이동거리 = 직전이동거리 + i;
            if (이동거리 > 0) {
                int r = solution(남은거리 - 이동거리, 이동거리, 이동수 + 1);
                if (r < 최소) 최소 = r;
            }
        }
        return 최소;
    }

    static List<Integer> solution1(int 남은거리, int 직전이동거리, int 이동수) {
        if (남은거리 == 0 && 직전이동거리 == 1) return new ArrayList<>();
        if ((남은거리 == 0 && 직전이동거리 != 1) ||남은거리 < 0 ) return null;

        List<Integer> 최소목록 = null;
        for (int i = -1; i <= 1; ++i) {
            int 이동거리 = 직전이동거리 + i;
            if (이동거리 > 0) {
                List<Integer> r = solution1(남은거리 - 이동거리, 이동거리, ++이동수);
                if (r != null) r.add(이동거리);
                if (최소목록 == null || (r != null && r.size() < 최소목록.size()))
                    최소목록 = r;
            }
        }
        return 최소목록;
    }

    static int solution2(int 거리) {
        int n = (int)Math.sqrt(거리);

        if (거리 < n*n) return -1111;
        if (거리 == n*n) return 2*n - 1;
        if (n*n < 거리 && 거리 <= n*n+n) return 2*n;
        System.out.printf("------------------ %d %f %d %d %d\n", 거리, Math.sqrt(거리), n, n*n, n*n + n);
        return 2*n + 1;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 50; ++i) {
            System.out.printf("%d %d %d\n", i, solution(i, 0, 0), solution2(i));
        }
        System.out.println("done");
    }
}