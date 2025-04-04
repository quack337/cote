package baekjoon.b01.b1011;

import java.util.ArrayList;
import java.util.List;

public class Main1 {

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

    static List<Integer> 탐색2(int 남은거리, int 직전이동거리, int 이동수) {
        if (남은거리 == 0 && 직전이동거리 == 1) return new ArrayList<>();
        if ((남은거리 == 0 && 직전이동거리 != 1) ||남은거리 < 0 ) return null;

        List<Integer> 최소목록 = null;
        for (int i = -1; i <= 1; ++i) {
            int 이동거리 = 직전이동거리 + i;
            if (이동거리 > 0) {
                List<Integer> r = 탐색2(남은거리 - 이동거리, 이동거리, ++이동수);
                if (r != null) r.add(이동거리);
                if (최소목록 == null || (r != null && r.size() < 최소목록.size()))
                    최소목록 = r;
            }
        }
        return 최소목록;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 40; ++i)
            System.out.printf("거리=%d, 점프수=%d, 점프방법=%s\n", i, 탐색1(i, 0, 0), 탐색2(i, 0, 0));
    }
}