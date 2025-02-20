package programmers.e92342;

import java.util.Arrays;

public class Main {

    static class Solution {
        static class Result {
            int 점수차이;
            int[] 목록;

            public Result(int 점수차이, int[] 목록) {
                this.점수차이 = 점수차이;
                this.목록 = 목록;
            }
        }

        int 점수차이계산(int[] a1, int[] a2) {
            int 점수1 = 0, 점수2 = 0;
            for (int i = 0; i <= 10; ++i)
                if (a1[i] > a2[i])
                    점수1 += (10 - i);
                else if (a2[i] != 0)
                    점수2 += (10 - i);
            return 점수1 - 점수2;
        }

        Result solution(int[] info, int index, int 남은화살수, int[] 목록) {
            if (남은화살수 == 0)
                return new Result(점수차이계산(목록, info), 목록);
            if (index == 10) {
                목록 = 목록.clone();
                목록[10] = 남은화살수;
                return new Result(점수차이계산(목록, info), 목록);
            }

            Result result1 = solution(info, index + 1, 남은화살수, 목록);

            if (info[index] < 남은화살수) {
                목록 = 목록.clone();
                목록[index] = info[index] + 1;
                Result result2 = solution(info, index + 1, 남은화살수 - 목록[index], 목록);
                if (result1.점수차이 == result2.점수차이)
                    for (int i = 10; i >= 0; --i)
                        if (result1.목록[i] != result2.목록[i])
                            return (result1.목록[i] > result2.목록[i]) ? result1 : result2;
                return (result1.점수차이 > result2.점수차이) ? result1 : result2;
            }
            return result1;
        }

        public int[] solution(int n, int[] info) {
            Result result = solution(info, 0, n, new int[11]);
            if (result.점수차이 > 0) return result.목록;
            return new int[] {-1};
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(5, new int[] {2,1,1,1,0,0,0,0,0,0,0})));
        System.out.println(Arrays.toString(sol.solution(1, new int[] {1,0,0,0,0,0,0,0,0,0,0})));
        System.out.println(Arrays.toString(sol.solution(9, new int[] {0,0,1,2,0,1,1,1,1,1,1})));
        System.out.println(Arrays.toString(sol.solution(10, new int[] {0,0,0,0,0,0,0,0,3,4,3})));
    }

}
