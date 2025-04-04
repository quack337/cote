package baekjoon.b16.p16900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

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

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = reader.readLine().split(" ");
        char[] S = temp[0].toCharArray();
        int K = Integer.parseInt(temp[1]);
        int[] p = kmpPattern(S);
        int size = p[p.length - 1];
        long answer = S.length + (S.length - size) * (K - 1L);
        System.out.println(answer);
    }
}