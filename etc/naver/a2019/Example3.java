package naver.a2019;

public class Example3 {

    static class Solution {

        // a[start..end] 범위에서 최대값을 구한다.
        int getMaxValue(int[] a, int start, int end) {
            int max = Integer.MIN_VALUE;
            for (int i = start; i <= end; ++i)
                if (a[i] > max) max = a[i];
            return max;
        }

        public int solution(int[] a) {
            int j = a.length - 1;
            while (a[j] > a[0]) // a[0] 보다 작은 값을 찾을 때까지 j 후진.
                --j;
            int winterMax = getMaxValue(a, 0, j); // 겨울 구간 최대값 구하기
            while (winterMax >= a[j]) // winterMax 보다 작거나 같으면 겨울이므로 j 전진
                ++j;
            return j;
        }
    }

    public static void main(String[] args) {
        int[] a1 = { 5, -2, 3, 8, 6 };
        int[] a2 = { -5, -5, -5, -42, 6, 12 };
        int[] a3 = { 5, -2, 3, 6, -2, 8 };
        int[] a4 = { -3, 6, -5, 3, 2, 7};
        Solution s = new Solution();
        System.out.println(s.solution(a1));
        System.out.println(s.solution(a2));
        System.out.println(s.solution(a3));
        System.out.println(s.solution(a4));
    }
}
