package baekjoon.b7575;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] kmpPattern(int[] pattern) {
        int[] table = new int[pattern.length];
        int J = 0;
        for (int i = 1; i < pattern.length; ++i) {
            while (J > 0 && pattern[i] != pattern[J])
                J = table[J - 1];
            if (pattern[i] == pattern[J]) {
                ++J;
                table[i] = J;
            }
        }
        return table;
    }

    static boolean kmp(int[] T, int[] P) {
        int[] table = kmpPattern(P);
        int J = 0;
        for (int i = 0; i < T.length; ++i) {
            while (J > 0 && T[i] != P[J])
                J = table[J - 1];
            if (T[i] == P[J]) {
                ++J;
                if (J == P.length) return true;
            }
        }
        return false;
    }

    static boolean checkVirus(int[][] A, int[] code1, int[] code2) {
        for(int i = 1; i < A.length; ++i) {
            if (kmp(A[i], code1) == false && kmp(A[i], code2) == false)
                return false;
        }
        return true;
    }

    static int[] reverse(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; ++i)
            B[i] = A[A.length - 1 - i];
        return B;
    }

    static boolean sol(int[][] A, int N, int K) {
        for (int i = 0; i < A[0].length - K + 1; ++i) {
            int[] code1 = Arrays.copyOfRange(A[0], i, i + K);
            int[] code2 = reverse(code1);
            if (checkVirus(A, code1, code2))
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        int[][] A = new int[N][];
        for (int i = 0; i < N; ++i) {
            int M = Integer.parseInt(reader.readLine());
            A[i] = new int[M];
            tokenizer = new StringTokenizer(reader.readLine());
            for (int m = 0; m < M; ++m)
                A[i][m] = Integer.parseInt(tokenizer.nextToken());
        }
        System.out.println(sol(A, N, K) ? "YES" : "NO");
    }
}