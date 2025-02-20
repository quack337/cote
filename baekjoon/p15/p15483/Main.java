package baekjoon.p15.p15483;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int 최소편집거리(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int[][] DP = new int[n1+1][n2+1];
        for (int i = 0; i <= n1; ++i)
            DP[i][0] = i;
        for (int j = 0; j <= n2; ++j)
            DP[0][j] = j;
        for (int i = 1; i <= n1; ++i)
            for (int j = 1; j <= n2; ++j) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    DP[i][j] = DP[i-1][j-1];
                else {
                    int a = DP[i-1][j-1] + 1;
                    int b = DP[i-1][j] + 1;
                    int c = DP[i][j-1] + 1;
                    DP[i][j] = Math.min(a, Math.min(b, c));
                }
            }
        return DP[n1][n2];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        System.out.println(최소편집거리(s1, s2));
    }
}

