package baekjoon.p01.p1509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    static char[] A;
    static Integer[][] DP;

    static boolean isPalindrome(int from, int to) {
        while (from < to)
            if (A[from++] != A[to--]) return false;
        return true;
    }

    static int sol(int from, int to) {
        if (DP[from][to] != null) return DP[from][to];
        if (isPalindrome(from, to)) return DP[from][to] = 1;
        int min = A.length;
        for (int middle = from; middle < to; ++middle)
            if (isPalindrome(from, middle)) {
                int count = 1 + sol(middle + 1, to);
                if (count < min) min = count;
            }
        return DP[from][to] = min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        A = reader.readLine().toCharArray();
        DP = new Integer[A.length][A.length];
        System.out.println(sol(0, A.length - 1));
    }
}