package baekjoon.p02.p2401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main3 {
    static char[] A;
    static int 문자열수;
    static int[] 문자열길이;
    static boolean[][] 붙여넣을수있나;
    static int[] DP;

    static int[] kmpPattern(char[] s) {
        int[] p = new int[s.length];
        int J = 0;
        for (int i = 1; i < s.length; ++i) {
            while (J > 0 && s[i] != s[J])
                J = p[J - 1];
            if (s[i] == s[J])
                p[i] = ++J;
        }
        return p;
    }

    static void 붙여넣을위치찾기(char[] 문자열, int 문자열번호) {
        int[] p = kmpPattern(문자열);
        int J = 0;
        for (int i = 0; i < A.length; ++i) {
            while (J > 0 && A[i] != 문자열[J])
                J = p[J - 1];
            if (A[i] == 문자열[J]) {
                ++J;
                if (J == 문자열.length) {
                    int 위치 = i - J + 1;
                    붙여넣을수있나[위치][문자열번호] = true;
                    J = p[J - 1];
                }
            }
        }
    }

    static int sol(int 위치) {
        if (위치 >= A.length) return 0;
        if (DP[위치] != -1) return DP[위치];
        int result = sol(위치 + 1);
        for (int i = 0; i < 문자열수; ++i)
            if (붙여넣을수있나[위치][i]) {
                int r = Math.max(result, 문자열길이[i] + sol(위치 + 문자열길이[i]));
                if (r > result) result = r;
            }
        return DP[위치] = result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        A = reader.readLine().toCharArray();
        문자열수 = Integer.parseInt(reader.readLine());
        문자열길이 = new int[문자열수];
        붙여넣을수있나 = new boolean[A.length][문자열수];
        for (int i = 0; i < 문자열수; ++i) {
            char[] 문자열 = reader.readLine().toCharArray();
            문자열길이[i] = 문자열.length;
            붙여넣을위치찾기(문자열, i);
        }
        DP = new int[A.length];
        Arrays.fill(DP, -1);
        int answer = sol(0);
        System.out.println(answer);
    }
}