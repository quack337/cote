package baekjoon.b13.p13506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] counts;

    static int[] kmpPattern(char[] s) {
        int[] p = new int[s.length];
        int J = 0;
        for (int i = 1; i < s.length; ++i) {
            while (J > 0 && s[i] != s[J])
                J = p[J - 1];
            if (s[i] == s[J]) {
                ++J;
                p[i] = J;
                counts[J]++;
            }
        }
        return p;
    }

    static String sol(String S) {
        char[] A = S.toCharArray();
        counts = new int[A.length];
        int[] p = kmpPattern(A);
        int size = p[p.length - 1];
        if (counts[size] == 1)
            size = p[size - 1];
        if (size == 0) return "-1";
        return S.substring(0, size);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String S = reader.readLine();
        System.out.println(sol(S));
    }
}