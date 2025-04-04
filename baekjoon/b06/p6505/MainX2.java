package baekjoon.b06.p6505;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MainX2 {
    static char[] encode(char[] x, int[] p) {
        char[] y = new char[x.length];
        for (int i = 0; i < x.length; ++i)
            y[p[i] - 1] = x[i];
        return y;
    }

    static String solution(int n, int m, int[] p, String s) {
        char[] original = s.toCharArray();
        char[] x = original;
        for (int i = 0; i < m; ++i) {
            x = encode(x, p);
            if (Arrays.equals(x, original))
                m = m % (i + 1);
        }
        return new String(x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());
            if (n == 0) break;
            int[] p = new int[n];
            tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; ++i)
                p[i] = Integer.parseInt(tokenizer.nextToken());
            String s = reader.readLine();
            System.out.println(solution(n, m, p, s));
        }
        reader.close();
    }

}