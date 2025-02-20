package baekjoon.p02.p2154;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        var builder = new StringBuilder();
        for (int i = 1; i <= N; ++i)
            builder.append(String.valueOf(i));
        String s = builder.toString();
        int answer = s.indexOf(String.valueOf(N)) + 1;
        System.out.println(answer);
    }
}
