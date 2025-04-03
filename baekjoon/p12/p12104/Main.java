package baekjoon.p12.p12104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] table;

    static int[] kmpPattern(char[] s) {
        int[] p = new int[s.length];
        int J = 0;
        for (int i = 1; i < s.length; ++i) {
            while (J > 0 && s[i] != s[J])
                J = p[J - 1];
            if (s[i] == s[J]) {
                ++J;
                p[i] = J;
            }
        }
        return p;
    }

    static boolean kmp(char[] t, char[] s) {
        table = kmpPattern(s);
        int J = 0;
        for (int i = 0; i < t.length * 2; ++i) {
            while (J > 0 && t[i % t.length] != s[J])
                J = table[J - 1];
            if (t[i % t.length] == s[J]) {
                ++J;
                if (J == s.length) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] A = reader.readLine().toCharArray();
        char[] B = reader.readLine().toCharArray();
        int count = 0;
        if (kmp(A, B) == false) count = 0;
        else {
            int N = A.length;
            int size = N - table[N - 1];
            if (size > 0 && N % size == 0)
                count = N / size; // 반복되는 패턴의 수
            else
                count = 1; // 반복되는 패턴이 없다면
        }
        System.out.println(count);
    }
}