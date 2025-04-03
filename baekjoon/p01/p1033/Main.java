package baekjoon.p01.p1033;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long 최대공약수(long a, long b){
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static long 최소공배수(long a, long b) {
        return a * b / 최대공약수(a, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        long[][] A = new long[N][N];
        long[] answer = new long[N];
        for (int i = 0; i < N - 1; ++i) {
            var tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int p = Integer.parseInt(tokenizer.nextToken());
            int q = Integer.parseInt(tokenizer.nextToken());
            long GCD = 최대공약수(p, q);
            A[a][b] = p / GCD;
            A[b][a] = q / GCD;
        }
        boolean done = false;
        while (done == false) {
            done = true;
            for (int row = 0; row < N; ++row) {
                long LCM = 1;
                for (int col = 0; col < N; ++col)
                    if (A[row][col] > 0)
                        LCM = 최소공배수(LCM, A[row][col]);
                if (answer[row] != LCM) {
                    done = false;
                    answer[row] = LCM;
                    for (int col = 0; col < N; ++col)
                        if (A[row][col] > 0) {
                            A[col][row] *= LCM / A[row][col];
                            A[row][col] = LCM;
                        }
                }
            }
        }
        for (long i : answer)
            System.out.print(i + " ");
    }
}