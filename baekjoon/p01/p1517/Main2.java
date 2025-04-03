package baekjoon.p01.p1517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int[] A, temp;
    static long count = 0;

    static void merge(int start, int middle, int end) {
        int i = start, i1 = start, i2 = middle + 1;
        while (i1 <= middle && i2 <= end)
            if (A[i2] < A[i1]) {
                temp[i++] = A[i2++];
                count += (middle - i1 + 1);
            } else
                temp[i++] = A[i1++];
        while (i1 <= middle)
            temp[i++] = A[i1++];
        while (i2 <= end)
            temp[i++] = A[i2++];
        System.arraycopy(temp, start, A, start, end - start + 1);
    }

    static void mergeSort(int start, int end) {
        if (start == end) return;
        int middle = (start + end) / 2;
        mergeSort(start, middle);
        mergeSort(middle + 1, end);
        merge(start, middle, end);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        A = new int[N];
        temp = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());
        mergeSort(0, N - 1);
        System.out.println(count);
    }
}