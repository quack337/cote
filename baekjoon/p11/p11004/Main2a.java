package baekjoon.p11.p11004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2a {
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
        while (start < end) {
            int middle = partition(A, start, end);
            int middle_nth = middle - start + 1;
            if (nth == middle_nth) return A[middle];
            if (nth < middle_nth)
                end = middle - 1;
            else {
                start = middle + 1;
                nth = nth - middle_nth;
            }
        }
        return A[start];
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
        System.out.println(select(A, 0, A.length-1, K));
    }
}