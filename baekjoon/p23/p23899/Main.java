package baekjoon.p23.p23899;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    static boolean selectionSort(int[] A, int[] B) {
        if (Arrays.equals(A, B)) return true;
        for (int i = A.length - 1; i > 0; --i) {
            int maxIndex = i;
            for (int j = 0; j < i; ++j)
                if (A[j] > A[maxIndex]) maxIndex = j;
            swap(A, maxIndex, i);
            if (Arrays.equals(A, B)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N], B = new int[N];
        for (int i = 0; i < N; ++i)
            A[i] = scanner.nextInt();
        for (int i = 0; i < N; ++i)
            B[i] = scanner.nextInt();
        scanner.close();
        System.out.println(selectionSort(A, B) ? "1" : "0");
    }
}