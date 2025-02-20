package baekjoon.p09.p9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
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

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        reader.close();
        DP = new int[s1.length()][s2.length()];
        for (int[] a : DP)
            Arrays.fill(a, -1);
        System.out.println(LCS(s1, 0, s2, 0));
    }
}
