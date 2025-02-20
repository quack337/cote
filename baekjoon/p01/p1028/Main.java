package baekjoon.p01.p1028;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] A;
    static Integer[][][] DP;

    static int lineSize(int r, int c, int no) {
        if (r < 0 || r >= R || c < 0 || c >= C) return 0;
        if (DP[r][c][no] != null) return DP[r][c][no];
        int size = 0;
        if (A[r][c] == '0') size = 0;
        else size = 1 + lineSize(r + 1, (no == 0) ? c - 1 : c + 1, no);
        return DP[r][c][no] = size;
    }

    static int findMaxSize() {
        for (int size = (Math.min(R, C) + 1) / 2; size >= 1; --size)
            for (int r1 = 0; true; ++r1) {
                int r2 = r1 + (size - 1) * 2;
                if (r2 == R) break;
                for (int c1 = 0; true; ++c1) {
                    int c2 = c1 + (size - 1) * 2;
                    if (c2 == C) break;
                    int rm = (r1 + r2) / 2, cm = (c1 + c2)/ 2;
                    if (lineSize(r1, cm, 0) >= size && lineSize(r1, cm, 1) >= size &&
                        lineSize(rm, c1, 1) >= size && lineSize(rm, c2, 0) >= size) {
                        return size;
                    }
                }
            }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());

        DP = new Integer[R][C][2];
        A = new char[R][C];
        for (int r = 0; r < R; ++r)
            A[r] = reader.readLine().toCharArray();
        System.out.println(findMaxSize());
    }
}
