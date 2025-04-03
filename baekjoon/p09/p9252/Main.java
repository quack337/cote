package baekjoon.p09.p9252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[][] DP;

    static String LCS(String s1, int index1, String s2, int index2) {
        if (index1 == s1.length() || index2 == s2.length()) return "";
        if (DP[index1][index2] != null) return DP[index1][index2];
        if (s1.charAt(index1) == s2.charAt(index2))
            return s1.charAt(index1) + LCS(s1, index1 + 1, s2, index2 + 1);
        else {
            String lcs1 = LCS(s1, index1, s2, index2 + 1);
            String lcs2 = LCS(s1, index1 + 1, s2, index2);
            return DP[index1][index2] = (lcs1.length() > lcs2.length()) ? lcs1 : lcs2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        reader.close();
        DP = new String[s1.length()][s2.length()];
        String lcs = LCS(s1, 0, s2, 0);
        System.out.println(lcs.length());
        System.out.println(lcs);
    }
}