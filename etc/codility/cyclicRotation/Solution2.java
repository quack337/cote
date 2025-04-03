package codility.cyclicrotation;

import java.util.Arrays;

public class Solution2 {

    public static int[] solution(int[] A, int K) {
        if (A.length == 0) return A;
        if (K == 0) return A;
        if (K > A.length) K = K % A.length;

        int[] B = Arrays.copyOf(A, A.length);
        for (int i = 0; i < A.length; ++i) {
            int index = i - K;
            if (index < 0) index = index + A.length;
            A[i] = B[index];
        }
        return A;
    }

    static void test(int[] A, int K) {
        solution(A, K);
        System.out.println(Arrays.toString(A));
    }

    public static void main(String[] args) {
        test(new int[] {3, 8, 9, 7, 6}, 3);
        test(new int[] {3, 8, 9, 7, 6}, 8);
        test(new int[] {3, 8, 9, 7, 6}, 5);
        test(new int[] {3, 8, 9, 7, 6}, 0);
        test(new int[] {3}, 3);
        test(new int[] {3}, 1);
        test(new int[] {3}, 0);
        test(new int[0], 3);
        test(new int[0], 0);
    }

}