package baekjoon.p10.p10989;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void countingSort(short[] a, int maxValue) {
        int[] count = new int[maxValue+1]; // maxValue+1 개의 count가 필요함.
        for (int i = 0; i < a.length; ++i)
            ++count[a[i]]; // a[i] 값 count 증가

        // 위에서 계산한 시작 위치를 사용하여 값들을 a 배열에 저장함. 즉 정렬함.
        int index = 0;
        for (int i = 0; i < count.length; ++i)
            for (int j = 0; j < count[i]; ++j)
                a[index++] = (short)i;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(reader.readLine());
        short[] A = new short[N];
        for (int i = 0; i < N; ++i)
            A[i] = Short.parseShort(reader.readLine());
        countingSort(A, 10000);
        for (short h : A)
            writer.write(h + "\n");
        writer.close();
    }
}