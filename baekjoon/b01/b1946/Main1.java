package baekjoon.b01.b1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int test = 0; test < T; ++test) {
            int N = Integer.parseInt(reader.readLine());
            int[][] A = new int[N][2];
            for (int i = 0; i < N; ++i) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                A[i][0] = Integer.parseInt(tokenizer.nextToken());
                A[i][1] = Integer.parseInt(tokenizer.nextToken());
            }

            for (int a = 0; a < N; ++a) {
                if (A[a] == null) continue; // 이미 삭제된 지원자
                for (int b = a + 1; b < N; ++b) {
                    if (A[b] == null) continue; // 이미 삭제된 지원자
                    if (A[a][0] < A[b][0] && A[a][1] < A[b][1])
                        A[b] = null; // b 지원자 삭제
                    else if (A[a][0] > A[b][0] && A[a][1] > A[b][1]) {
                        A[a] = null; // a 지원자 삭제
                        break;
                    }
                }
            }

            int count = 0;
            for (int i = 0; i < N; ++i)
                if (A[i] != null) ++count;
            System.out.println(count);
        }
    }
}