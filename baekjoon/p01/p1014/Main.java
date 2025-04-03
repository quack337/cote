package baekjoon.p01.p1014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, 패턴최대값;
    static char[][] A;
    static Integer[][] DP;

    static int getBit(int value, int nth) { // value의 nth 비트값 (0 or 1)
        if (nth < 0 || nth >= R) return 0;
        return (value >> nth) & 1;
    }

    static int countBit1(int value) { // value에 포함된 1 비트 수
        int count = 0;
        for (int i = 0; i < R; ++i)
            if (getBit(value, i) == 1) ++count;
        return count;
    }

    static boolean isValid(int 패턴, int 이전패턴, int col) { // 패턴이 호환되는가?
        for (int r = 0; r < R; ++r)
            if (getBit(패턴, r) == 1) {
                if (A[r][col] == 'x') return false;
                if (getBit(이전패턴, r - 1) == 1) return false;
                if (getBit(이전패턴, r) == 1) return false;
                if (getBit(이전패턴, r + 1) == 1) return false;
            }
        return true;
    }

    static int sol(int col, int 이전패턴) {
        if (col == C) return 0;
        if (DP[col][이전패턴] != null) return DP[col][이전패턴];
        int result = 0;
        for (int 패턴 = 0; 패턴 <= 패턴최대값; ++패턴)
            if (isValid(패턴, 이전패턴, col))
                result = Math.max(result, countBit1(패턴) + sol(col + 1, 패턴));
        return DP[col][이전패턴] = result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; ++t) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            R = Integer.parseInt(tokenizer.nextToken());
            C = Integer.parseInt(tokenizer.nextToken());
            패턴최대값 = (1 << R) - 1; // R개의 비트가 모두 1인 이진수
            A = new char[R][];
            DP = new Integer[C][패턴최대값+1];
            for (int r = 0; r < R; ++r)
                A[r] = reader.readLine().toCharArray();
            System.out.println(sol(0, 0));
        }
    }
}