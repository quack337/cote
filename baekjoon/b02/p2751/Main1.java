package baekjoon.b02.p2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static int partition(int[] a, int start, int end) {
        swap(a, (start+end)/2, end);
        int value = a[end];
        int i = start - 1;
        for (int j = start; j <= end - 1; ++j)
            if (a[j] < value)
                swap(a, ++i, j);
        swap(a, i + 1, end);
        return i + 1;
    }

    static void quickSort(int[] a, int start, int end) {
        if (start >= end) return;
        int middle = partition(a, start, end);
        quickSort(a, start, middle-1);
        quickSort(a, middle+1, end);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] a = new int[N];
        for (int i = 0; i < N; ++i)
            a[i] = Integer.parseInt(reader.readLine());
        quickSort(a, 0, N-1);
        for (int i : a)
            System.out.println(i);
    }
}