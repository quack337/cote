package baekjoon.p01.p1120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int diff(char[] a, char[] b, int i) {
        if (i < 0) return 0;
        return diff(a, b, i-1) + (a[i] != b[i] ? 1: 0);
    }

    static int 최소차이수(String a, String b) {
        if (a.length() == b.length())
            return diff(a.toCharArray(), b.toCharArray(), a.length()-1);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= b.length() - a.length(); ++i)
            min = Math.min(min, 최소차이수(a, b.substring(i, i + a.length())));
        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        System.out.println(최소차이수(tokenizer.nextToken(), tokenizer.nextToken()));
    }
}
