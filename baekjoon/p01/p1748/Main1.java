package baekjoon.p01.p1748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        long result = 0;
        for (int i = 1; i <= N; ++i)
            result += String.valueOf(i).length();
        System.out.println(result);
    }
}