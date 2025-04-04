package baekjoon.b10.p10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // 256진수로 표현했을 때, nth 자리를 기준으로 정렬한다.
    public static void countingSort(short[] a, int start, int end, int nth) {
        int[] count = new int[256]; // 256개의 count가 필요함.
        for (int i = start; i <= end; ++i) {
            int value = a[i];
            int digit = value >> (nth * 8) & 0xFF; // nth 자리의 값을 구함
            ++count[digit]; // digit 값 count 증가
        }
        // nth 자리의 값을 기준으로 정렬 했을 때, 각 값의 시작 위치 계산
        int[] index = new int[256]; // 시작 위치 배열
        index[0] = 0;
        for (int i = 1; i < index.length; ++i)
            index[i] = index[i - 1] + count[i - 1];

        // 위에서 계산한 시작 위치를 사용하여 값들을 temp 배열에 복사함. 즉 정렬함.
        short[] temp = new short[end - start + 1];
        for (int i = start; i <= end; ++i) {
            short value = a[i];
            int digit = value >> (nth * 8) & 0xFF;
            temp[index[digit]++] = value;
        }

        // 정렬된 temp 배열의 값을 입력 배열에 복사
        for (int i = start; i <= end; ++i)
            a[i] = temp[i - start];
    }

    public static void radixSort(short[] a) {
        // 16bit이므로, 256진수 2자리
        for (int i = 0; i < 2; ++i)
            countingSort(a, 0, a.length - 1, i);        // 음수 정렬
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        short[] A = new short[N];
        for (int i = 0; i < N; ++i)
            A[i] = Short.parseShort(reader.readLine());
        radixSort(A);
        for (short h : A)
            System.out.println(h);
    }
}