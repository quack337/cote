package codility.cyclicrotation;

import java.util.Arrays;

public class Solution1 {

    public static int[] solution(int[] A, int K) {
        int[] B = Arrays.copyOf(A, A.length);
        for (int i = 0; i < A.length; ++i) {
            int index = i - K;
            if (index < 0) index = index + A.length;
            A[i] = B[index];
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {3, 8, 9, 7, 6};
        solution(A, 3);
        System.out.println(Arrays.toString(A));
    }

}