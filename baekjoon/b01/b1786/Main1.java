package baekjoon.b01.b1786;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    static void kmp(char[] T, char[] P) {
        int[] table = kmpPattern(P);
        int J = 0;
        for (int i = 0; i < T.length; ++i) {
            while (J > 0 && T[i] != P[J])
                J = table[J - 1];
            if (T[i] == P[J]) {
                ++J;
                if (J == P.length) {
                    ++count;
                    builder.append((i - J + 2) + " ");
                    J = table[J - 1];
                };
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] T = reader.readLine().toCharArray();
        char[] P = reader.readLine().toCharArray();
        kmp(T, P);
        builder.insert(0, count + "\n");
        System.out.println(builder.toString());
    }
}