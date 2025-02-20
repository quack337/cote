package programmers.e42862;

import java.util.Arrays;

public class Main {

    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int lostCount = lost.length;
            Arrays.sort(lost);
            Arrays.sort(reserve);
            int i1 = 0, i2 = 0;
            while (i1 < lost.length && i2 < reserve.length) {
                if (lost[i1] < reserve[i2]) ++i1;
                else if (lost[i1] > reserve[i2]) ++i2;
                else {
                    --lostCount;
                    lost[i1] = reserve[i2] = 0;
                    ++i1; ++i2;
                }
            }
            i1 = 0; i2 = 0;
            while (i1 < lost.length && i2 < reserve.length) {
                if (lost[i1] == 0) { ++i1; continue; }
                if (reserve[i2] == 0) { ++i2; continue; }

                if (reserve[i2] < lost[i1] - 1)
                    ++i2;
                else if (reserve[i2] <= lost[i1] + 1) {
                    --lostCount;
                    ++i2;
                    ++i1;
                }
                else
                    ++i1;
            }
            return n - lostCount;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        System.out.println(sol.solution(5, new int[] {2,4}, new int[] {1,3,5}));
        System.out.println(sol.solution(5, new int[] {2,4}, new int[] {3}));
        System.out.println(sol.solution(3, new int[] {3}, new int[] {1}));

        System.out.println(sol.solution(5, new int[] {2,3,4}, new int[] {1,2,3}));
    }
}
