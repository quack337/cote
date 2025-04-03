package baekjoon.p02.p2661;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
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

    static boolean DFS(int[] a, int index) {
        if (index == a.length) return true;
        for (int c = 1; c <= 3; ++c) {
            a[index] = c;
            if (valid(a, index+1) && DFS(a, index+1))
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] a = new int[N];
        a[0] = 1;
        DFS(a, 1);
        for (int i : a)
            System.out.print(i);
    }
}