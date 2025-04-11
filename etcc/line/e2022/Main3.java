package etcc.line.e2022;
import static java.lang.Math.abs;
import static java.lang.Math.max;

import java.util.Arrays;

public class Main3 {

    static long[][] solution(int N, int M, int[][] fires, int[][] ices) {
        var result = new long[N][N];
        for (int[] a : fires) result[a[0]-1][a[1]-1]--;
        for (int[] a : ices) result[a[0]-1][a[1]-1]++;
        for (int r = 1; r <= N; ++r)
            for (int c = 1; c <= N; ++c) {
                for (int[] a : fires) {
                    int distance = max(abs(r - a[0]), abs(c - a[1]));
                    result[r-1][c-1] += max(0, M - distance + 1);
                }
                for (int[] a : ices) {
                    int distance = abs(r - a[0]) + abs(c - a[1]);
                    result[r-1][c-1] -= max(0, M - distance + 1);
                }
            }
        return result;
    }

    public static void main(String[] args) {
        var r = solution(3, 2, new int[][] {{1,1}}, new int[][] {{3,3}});
        System.out.println(Arrays.deepToString(r));

        r = solution(5, 3, new int[][] {{5,5},{1,3},{5,2}},
                new int[][] {{1,5},{3,2}});
        System.out.println(Arrays.deepToString(r));
    }
}