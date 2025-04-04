package baekjoon.b02.p2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int result =  -1;
        for (int i = N / 5; i >= 0; --i)
            if ((N - i * 5) % 3 == 0) {
                result = i + (N - i * 5) / 3;
                break;
            }
        System.out.println(result);
    }
}