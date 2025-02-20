package baekjoon.p01.p1038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    static boolean 감소하는수(long n) {
        int count = 0;
        long previous = 0;
        while (n > 0) {
            long d = n % 10;
            if (count > 0) {
                if (d <= previous) return false;
            }
            previous = d;
            ++count;
            n /= 10;
        }
        return true;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int count = -1;
        for (long n = 0; true; ++n) {
            if (감소하는수(n)) ++count;
            if (count == N) {
                System.out.println(n);
                break;
            }
        }
    }
}
