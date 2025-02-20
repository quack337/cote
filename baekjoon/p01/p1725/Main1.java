package baekjoon.p01.p1725;

import static java.lang.Math.max;

import java.util.Scanner;

public class Main1 {
    static int findMin(int[] A, int from, int to) {
        int index = from;
        for (int i = from + 1; i <= to; ++i)
            if (A[i] < A[index]) index = i;
        return index;
    }

    static int solution(int[] A, int from, int to) {
        if (from > to) return 0;
        int index = findMin(A, from, to);
        int value = A[index];
        int 면적1 = value * (to - from + 1);
        int 면적2 = solution(A, from, index - 1);
        int 면적3 = solution(A, index + 1, to);
        return max(면적1, max(면적2, 면적3));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; ++i)
            A[i] = scanner.nextInt();
        scanner.close();
        System.out.println(solution(A, 0, N-1));
    }
}
