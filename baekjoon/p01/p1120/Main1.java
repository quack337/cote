package baekjoon.p01.p1120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    static int 최소차이수(String s1, String s2) {
        if (s1.length() == s2.length()) {
            int count = 0;
            for (int i = 0; i < s1.length(); ++i)
                if (s1.charAt(i) != s2.charAt(i)) ++count;
            return count;
        }
        int min = Integer.MAX_VALUE;
        int difference = s2.length() - s1.length();
        for (int i = 0; i <= difference; ++i) {
            String prefix = s2.substring(0, i);
            String postfix = s2.substring(s2.length() - difference + i, s2.length());
            min = Math.min(min, 최소차이수(prefix + s1 + postfix, s2));
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        String a = tokenizer.nextToken();
        String b = tokenizer.nextToken();
        System.out.println(최소차이수(a, b));
    }
}
