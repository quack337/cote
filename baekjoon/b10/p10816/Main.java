package baekjoon.b10.p10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 정렬된 A 배열에서, value 값의 첫 index 찾기
    static int firstIndex(int[] A, int value) {
        int end = Arrays.binarySearch(A, value);
        int start = Arrays.binarySearch(A, value-1);
        if (start < 0) return -start - 1;
        else {
            while (start+1 < end) {
                int middle = (start + end) / 2;
                if (A[middle] == value) end = middle;
                else start = middle;
            }
            return end;
        }
    }

    // 정렬된 A 배열에서, value 값의 마지막 index 찾기
    static int lastIndex(int[] A, int value) {
        int start = Arrays.binarySearch(A, value);
        int end = Arrays.binarySearch(A, value+1);
        if (end < 0) return -end - 2;
        else {
            while (start+1 < end) {
                int middle = (start + end) / 2;
                if (A[middle] == value) start = middle;
                else end = middle;
            }
            return start;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] A = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());
        Arrays.sort(A);
        int M = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < M; ++i) {
            int value = Integer.parseInt(tokenizer.nextToken());
            int index = Arrays.binarySearch(A, value);
            if (index < 0) builder.append(0).append(' ');
            else {
                int start = firstIndex(A, value);
                int end = lastIndex(A, value);
                builder.append(end - start + 1).append(' ' );
            }
        }
        System.out.println(builder.toString());
    }
}