package baekjoon.p12.p12015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] A = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());

        int[] 길이 = new int[N+1];
        길이[0] = Integer.MIN_VALUE;
        int count = 1;
        for (int i = 0; i < N; ++i) {
            int index = Arrays.binarySearch(길이, 0, count, A[i]);
            if (index < 0) index = -index - 1;
            if (index == count) ++count;
            길이[index] = A[i];
        }
        System.out.println(count - 1);
    }
}
