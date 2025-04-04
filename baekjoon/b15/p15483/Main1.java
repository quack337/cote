package baekjoon.b15.p15483;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1 {
    static int 최소편집1(String s1, String s2) {
        if (s1.length() == 0) return s2.length();
        if (s2.length() == 0) return s1.length();
        if (s1.charAt(0) == s2.charAt(0))
            return 최소편집1(s1.substring(1), s2.substring(1));
        else {
            if (s1.length() < s2.length()) {
                String t = s1;
                s1 = s2;
                s2 = t;
            }
            int r1 = 최소편집1(s1.substring(1), s2);
            int r2 = 최소편집1(s1, s1.charAt(0) + s2);
            int r3 = 최소편집1(s2.charAt(0) + s1.substring(1), s2);
            int r4 = 최소편집1(s1, s1.charAt(0) + s2.substring(1));
            return Math.min(Math.min(r1,r2), Math.min(r3, r4)) + 1;
        }
    }

    static int[][] DP;

    static int LCS(String s1, int index1, String s2, int index2) {
        if (index1 == s1.length() || index2 == s2.length()) return 0;
        if (DP[index1][index2] > -1) return DP[index1][index2];
        if (s1.charAt(index1) == s2.charAt(index2))
            return 1 + LCS(s1, index1 + 1, s2, index2 + 1);
        else {
            int lcs1 = LCS(s1, index1, s2, index2 + 1);
            int lcs2 = LCS(s1, index1 + 1, s2, index2);
            return DP[index1][index2] = Math.max(lcs1, lcs2);
        }
    }

    static int 위치일치문자수(String s1, String s2) {
        int n = Math.min(s1.length(), s2.length());
        int count = 0;
        for (int i = 0; i < n; ++i)
            if (s1.charAt(i) == s2.charAt(i)) ++count;
        return count;
    }

    static int 최소편집2(String s1, String s2) {
        DP = new int[s1.length()][s2.length()];
        for (int[] a : DP) Arrays.fill(a, -1);
        int lcs = LCS(s1, 0, s2, 0);
        int n1 = s1.length() + s2.length() - lcs * 2;
        int cc = 위치일치문자수(s1, s2);
        int n2 = Math.max(s1.length(), s2.length()) - cc;
        //System.err.printf("%s %s %d %d %d\n", s1, s2, lcs, n1, n2);
        return Math.min(n1, n2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        System.out.println(최소편집2(s1, s2));
    }
}