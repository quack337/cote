package baekjoon.b01.b1790;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int length(int value) {
        int result = 0;
        while (value > 0) {
            ++result;
            value /= 10;
        }
        return result;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        long N = Long.parseLong(tokenizer.nextToken());
        long K = Long.parseLong(tokenizer.nextToken());
        long result = 0;
        int i;
        for (i = 1; i <= N; ++i) {
            result += length(i);
            if (result >= K) break;
        }
        if (result >= K) {
            String s = String.valueOf(i);
            int index = s.length() - 1 - (int)(result - K);
            System.out.println(s.charAt(index));
        } else
            System.out.println(-1);
    }
}