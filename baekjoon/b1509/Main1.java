package baekjoon.b1509;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    static char[] A;

    static boolean isPalindrome(int from, int to) {
        while (from < to)
            if (A[from++] != A[to--]) return false;
        return true;
    }

    static int count = 0;

    static int sol(int from, int to) {
        if (isPalindrome(from, to)) return 1;
        int min = A.length;
        for (int middle = from; middle < to; ++middle)
            if (isPalindrome(from, middle)) {
                int count = 1 + sol(middle + 1, to);
                if (count < min) min = count;
            }
        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        A = reader.readLine().toCharArray();
        System.out.println(sol(0, A.length - 1));
    }
}