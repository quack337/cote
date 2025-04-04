package baekjoon.b06.p6064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int 최대공약수(int a, int b) {
        while (b > 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static int 최소공배수(int a, int b) {
        return a * b / 최대공약수(a, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; ++t) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int M = Integer.parseInt(tokenizer.nextToken());
            int N = Integer.parseInt(tokenizer.nextToken());
            int X = Integer.parseInt(tokenizer.nextToken());
            int Y = Integer.parseInt(tokenizer.nextToken());

            int sol = -1;
            int MAX = 최소공배수(M, N);
            for (int year = 0; year <= MAX; ++year) {
                int x = (year % M) + 1;
                int y = (year % N) + 1;
                if (x == X && y == Y) {
                    sol = year + 1;
                    break;
                }
            }
            System.out.println(sol);
        }
    }
}