package baekjoon.p11.p11004;

import java.util.Scanner;

public class Main1 {
    static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    static int partition(int[] A, int start, int end) {
        swap(A, (start + end) / 2, end); // 배열의 중간에 있는 값을 기준 값으로
        int i = start - 1, pivot = A[end];
        for (int j = start; j < end; ++j)
            if (A[j] < pivot)
                swap(A, ++i, j);
        swap(A, ++i, end);
        return i;
    }

    static int select(int[] A, int start, int end, int nth) {
        if (start >= end) return A[start];
        int middle = partition(A, start, end);
        int middle_nth = middle - start + 1;
        if (nth == middle_nth) return A[middle];
        if (nth < middle_nth)
            return select(A, start, middle-1, nth);
        else
            return select(A, middle+1, end, nth - middle_nth);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; ++i)
                A[i] = scanner.nextInt();
            System.out.println(select(A, 0, A.length-1, K));
        }
    }

}
