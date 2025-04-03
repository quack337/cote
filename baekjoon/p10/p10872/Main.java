package baekjoon.p10.p10872;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; ++i)
            result *= i;
        return result;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        System.out.println(factorial(N));
    }
}