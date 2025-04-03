package baekjoon.p01.p1977;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(reader.readLine());
        int N = Integer.parseInt(reader.readLine());
        int start = (int)Math.sqrt(M);
        int end = (int)Math.sqrt(N);
        int sum = 0, min = 0;
        for (int i = start; i <= end; ++i) {
            int s = i * i;
            if (s < M) continue;
            if (min == 0) min = s;
            sum += s;
        }
        if (min == 0)
            System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }

}