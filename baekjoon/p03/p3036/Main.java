package baekjoon.p03.p3036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int 최대공약수(int a, int b){
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int a = Integer.parseInt(tokenizer.nextToken());
        for (int i = 0; i < N-1; ++i) {
            int b = Integer.parseInt(tokenizer.nextToken());
            int gcd = 최대공약수(a, b);
            System.out.printf("%d/%d\n", a/gcd, b/gcd);
        }
    }
}