package baekjoon.p11.p11004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static int partitionBy0(int[] a) {
        int i = -1;
        for (int j = 0; j < a.length; ++j)
            if (a[j] < 0)
                swap(a, ++i, j);
        return i + 1;
    }

    public static void countingSort(int[] a, int start, int end, int nth) {
        int[] count = new int[256];
        for (int i = start; i <= end; ++i) {
            int value = a[i];
            int digit = value >> (nth * 8) & 0xFF;
            ++count[digit];
        }
        int[] index = new int[256];
        index[0] = 0;
        for (int i = 1; i < index.length; ++i)
            index[i] = index[i - 1] + count[i - 1];
        int[] temp = new int[end - start + 1];
        for (int i = start; i <= end; ++i) {
            int value = a[i];
            int digit = value >> (nth * 8) & 0xFF;
            temp[index[digit]++] = value;
        }
        for (int i = start; i <= end; ++i)
            a[i] = temp[i - start];
    }

    public static void radixSort(int[] a) {
        int middle = partitionBy0(a);

        for (int i = 0; i < 4; ++i) {
            countingSort(a, 0, middle - 1, i);
            countingSort(a, middle, a.length - 1, i);
        }
    }

    static int select(int[] a, int nth) {
        radixSort(a);
        return a[nth - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        int[] A = new int[N];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());
        System.out.println(select(A, K));
    }
}
