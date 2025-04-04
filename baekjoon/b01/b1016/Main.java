package baekjoon.b01.b1016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        long MIN = Long.parseLong(tokenizer.nextToken());
        long MAX = Long.parseLong(tokenizer.nextToken());
        reader.close();
        boolean[] a = new boolean[(int)(MAX - MIN + 1)];
        for (long i = 2; true; ++i) {
            long square = i * i;
            if (square > MAX) break;
            long t = (MIN / square) * square;
            while (t < MIN)
                t += square;
            while (t <= MAX) {
                a[(int)(t - MIN)] = true;
                t += square;
            }
        }
        int count = 0;
        for (boolean b : a)
            if (b == false) ++count;
        System.out.println(count);
    }
}