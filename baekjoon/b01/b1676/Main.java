package baekjoon.b01.b1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int factorial(int n) {
        long result = 1;
        int count = 0;
        for (int i = 2; i <= n; ++i) {
            int temp = i;
            while (temp % 10 == 0) {
                temp /= 10;
                ++count;
            }
            result *= temp;
            while (result % 10 == 0) {
                result /= 10;
                ++count;
            }
            result %= 1000000;
        }
        return count;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        System.out.println(factorial(N));
    }
}