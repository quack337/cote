package baekjoon.p01.p1940;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1 {
    public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        int[] A = new int[N];
        String s = reader.readLine();
        var tokennizer = new StringTokenizer(s);
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokennizer.nextToken());
        reader.close();
        Arrays.sort(A);

        int answer = 0;
        for (int i = 0; i < N && A[i] <= M/2; ++i) {
            int j = Arrays.binarySearch(A, M - A[i]);
            if (j >= 0 && i != j)
                ++answer;
        }
        System.out.println(answer);
    }
}
