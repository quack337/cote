package baekjoon.b01.b1065;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean 한수(int n) {
        if (n < 100) return true;
        int count = 0, difference = 0, previous = 0;
        while (n > 0) {
            int d = n % 10;
            if (count > 1) {
                if (d - previous != difference) return false;
            } else if (count == 1) {
                difference = d - previous;
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
        int count = 0;
        for (int i = 1; i <= N; ++i)
            if (한수(i)) ++count;
        System.out.println(count);
    }
}