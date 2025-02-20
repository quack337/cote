package baekjoon.p01.p1253;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        long[] A = new long[N];
        String s = reader.readLine();
        var tokennizer = new StringTokenizer(s);
        for (int i = 0; i < N; ++i)
            A[i] = Long.parseLong(tokennizer.nextToken());
        reader.close();
        Arrays.sort(A);
        int answer = 0;
        for (int i = 0; i < A.length; ++i) {
            int i1 = 0, i2 = A.length - 1;
            while (i1 < i2) {
                if (i1 == i) { ++i1; continue; }
                if (i2 == i) { --i2; continue; }
                if (A[i1] + A[i2] == A[i]) {
                    ++answer;
                    break;
                } else if (A[i1] + A[i2] < A[i])
                    ++i1;
                else if (A[i1] + A[i2] > A[i])
                    --i2;
            }
        }
        System.out.println(answer);
    }
}
