package baekjoon.p02.p2903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int f(int n) {
        if (n == 0) return 2;
        return f(n - 1) * 2 - 1;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        reader.close();
        int t = f(N);
        System.out.println(t * t);
    }
}