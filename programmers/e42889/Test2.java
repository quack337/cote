package programmers.e42889;

import java.util.Arrays;

public class Test2 {

    static class Solution {
        public int[] solution(int N, int[] stages) {
            int[] 멈춤 = new int[N+1];
            for (int s : stages)
                멈춤[s - 1]++;
            int[] 도달 = new int[N+1];
            도달[N] = 멈춤[N];
            for (int i = N-1; i >= 0; --i)
                도달[i] = 도달[i+1] + 멈춤[i];
            double[][] 실패율 = new double[N][2];
            for (int i = 0; i < N; ++i) {
                실패율[i][0] = (double)멈춤[i] / (double)도달[i];
                실패율[i][1] = i+1;
            }
            Arrays.sort(실패율, (a, b) -> {
                int r = (int)Math.signum(b[0] - a[0]);
                return (r != 0) ? r : (int)(a[1] - b[1]);
            });
            int[] result = new int[N];
            for (int i = 0; i < N; ++i)
                result[i] = (int)실패율[i][1];
            return result;
        }
    }

    public static void main(String[] args) {
        int[] a1 = {2, 1, 2, 6, 2, 4, 3, 3}; // [3,4,2,1,5]
        int[] a2 = {4,4,4,4,4};              // [4,1,2,3]
        System.out.println(Arrays.toString(new Solution().solution(5, a1)));
        System.out.println(Arrays.toString(new Solution().solution(4, a2)));
    }

}