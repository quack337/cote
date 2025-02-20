package programmers.e17681;

import java.util.Arrays;


public class Main {

    static class Solution {

        String[] solution(int n, int[] arr1, int[] arr2) {
            String[] result = new String[n];
            for (int i = 0; i < n; ++i) {
                StringBuilder b = new StringBuilder();
                for (int j = n - 1; j >= 0; --j)
                    b.append( ((arr1[i] | arr2[i]) >> j & 1) == 1 ? '#' : ' ');
                result[i] = b.toString();
            }
            return result;
        }
    }

    static void print(String[] a) {
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        print(sol.solution(5, new int[] {9, 20, 28, 18, 11}, new int[] {30, 1, 21, 17, 28}));
        print(sol.solution(6, new int[] {46, 33, 33, 22, 31, 50}, new int[] {27, 56, 19, 14, 14, 10}));
    }

}
