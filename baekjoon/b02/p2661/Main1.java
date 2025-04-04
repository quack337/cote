package baekjoon.b02.p2661;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    static boolean valid(int[] a, int size) {
        for (int i = 1; i <= size/2; ++i) {
            int start1 = size - i;
            int start2 = size - 2 * i;
            boolean equal = true;
            for (int j = 0; equal && j < i; ++j)
                if (a[start1 + j] != a[start2 + j]) equal = false;
            if (equal) return false;
        }
        return true;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] A = new int[N];
        A[0] = 1;
        for (int i = 1; i < N; ++i) {
            for (int c = 1; c <= 3; ++c) {
                A[i] = c;
                if (valid(A, i+1)) break;
            }
        }
        for (int i : A)
            System.out.print(i);
    }
}