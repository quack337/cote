package baekjoon.p02.p2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    static int N;
    static int[] A;

    static void solution() {
        for (int i = 0; i < A.length; ++i) {
            int no = 0;
            for (int j = i - 1; j >= 0; --j)
                if (A[j] >= A[i]) {
                    no = j + 1;
                    break;
                }
            System.out.printf("%d ", no);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        A = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());
        solution();
    }
}
