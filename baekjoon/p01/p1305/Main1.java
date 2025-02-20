package baekjoon.p01.p1305;

import java.util.Arrays;

public class Main1 {

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

    public static void main(String[] args) {
        String[] b = new String[] {
                "aaaaaaaaaaa", // a
                "abababababababababababab", // ab
                "abcabcabcabcabcabcabc", // abc
                "ababcabababcabababcabababcab" //ababcab
                };
        for (String s : b) {
            int[] p = kmpPattern(s.toCharArray());
            System.out.print(p.length - p[p.length-1]);
            System.out.println(Arrays.toString(p));
        }
    }
}

