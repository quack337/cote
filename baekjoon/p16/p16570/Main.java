package baekjoon.p16.p16570;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] kmpPattern(int[] s) {
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

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] A = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            A[N - 1 - i] = Integer.parseInt(tokenizer.nextToken());
        int[] p = kmpPattern(A);
        int max = 0, count = 0;
        for (int i = 0; i < N; ++i)
            if (p[i] > max) { max = p[i]; count = 1; }
            else if (p[i] == max) ++count;
        System.out.println((max == 0) ? "-1" : (max + " " + count));
        System.out.println(Arrays.toString(p));
    }
}
