package baekjoon.p11.p11585;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main1 {
    static StringBuilder builder = new StringBuilder();
    static int count = 0;

    static int[] kmpPattern(char[] pattern) {
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

    static char[] getArray(Reader reader, int N) throws IOException {
        char[] A = new char[N];
        for (int i = 0; i < N; ) {
            int ch = reader.read();
            if (Character.isAlphabetic(ch))
                A[i++] = (char)ch;
        }
        return A;
    }

    static int 최대공약수(int a, int b){
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        char[] 메뉴 = getArray(reader, N);
        int[] p = kmpPattern(메뉴);
        int size = N - p[N-1];
        if (N % size == 0 && N / size > 1) {
            int lcd = 최대공약수(N / size, N);
            System.out.println((N/size/lcd) + "/" + (N/lcd));
        } else
            System.out.println("1/" + N);
    }
}
