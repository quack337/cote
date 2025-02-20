package alospot.boggle;

import java.util.Scanner;

public class Main2 {

    static Boolean[][][] DP;

    static boolean DFS(char[][] map, int row, int col, int index, String s) {
        if (index == s.length()) return true;
        if (row < 0 || col < 0 || row >= 5 || col >= 5) return false;
        if (DP[row][col][index] != null) return DP[row][col][index];
        if (map[row][col] != s.charAt(index)) return false;
        for (int dr = -1; dr <= 1; ++dr)
            for (int dc = -1; dc <= 1; ++dc)
                if (dr != 0 || dc != 0)
                    if (DFS(map, row + dr, col + dc, index + 1, s))
                        return DP[row][col][index] = true;
        return DP[row][col][index] = false;
    }

    static boolean 탐색(char [][] map, String s) {
        DP = new Boolean[5][5][10];
        for (int r = 0; r < 5; ++r)
            for (int c = 0; c < 5; ++c)
                if (DFS(map, r, c, 0, s)) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        char[][] map = new char[5][];
        for (int t = 0; t < T; ++t) {
           for (int r = 0; r < 5; ++r) {
                String s = scanner.next();
                map[r] = s.toCharArray();
           }
            int W = scanner.nextInt();
            for (int w = 0; w < W; ++w) {
                String s = scanner.next();
                System.out.println(s + (탐색(map, s) ? " YES" : " NO"));
            }
        }
        scanner.close();
    }
}
