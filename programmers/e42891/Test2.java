package programmers.e42891;

import java.util.Arrays;

public class Test2 {

    static class Solution {

        public int solution(int[] foods, long k) {
            int[][] sorted = new int[foods.length][2];
            for (int i = 0; i < sorted.length; ++i) {
              sorted[i][0] = foods[i];
              sorted[i][1] = i;
            }
            Arrays.sort(sorted, (a, b) -> {
                int r = a[0] - b[0];
                return r != 0 ? r : a[1] - b[1];
            });
            int countPositive = foods.length;
            long 차감 = 0;
            int i;
            for (i = 0; i < sorted.length; ++i) {
               long temp = ((sorted[i][0] - 차감) * countPositive);
               if (k < temp) break;
               k -= temp;
               --countPositive;
               차감 = 차감 + (sorted[i][0] - 차감);
            }
            if (i == sorted.length) return -1;
            for (int h = 0; h < sorted.length; ++h)
                foods[h] = (int)Math.max(0, foods[h] - 차감);

            k = k % countPositive;
            i = 0;
            while (true) {
                if (foods[i] != 0) {
                    --k;
                    if (k == -1) return i+1;
                }
                ++i;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[] {3,1,2}, 5));
        System.out.println(new Solution().solution(new int[] {1,2}, 1));
    }

}