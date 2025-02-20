package baekjoon.p02.p2154;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    static int[] pattern(int[] s) {
        int[] p = new int[s.length];
        int J = 0;
        for (int i = 1; i < s.length; ++i) {
            while (J > 0 && s[i] != s[J])
                J = p[J - 1];
            if (s[i] == s[J]) {
                ++J;
                p[i] = J;
            }
        }
        return p;
    }

    static class Matcher {
        int[] digits, p;
        int index;

        public Matcher(int[] digits) {
            this.digits = digits;
            this.p = pattern(digits);
            this.index = 0;
        }

        public boolean match(int digit) {
            while (index > 0 && digit != digits[index])
                index = p[index - 1];
            if (digit == digits[index]) {
                ++index;
                if (index == digits.length) return true;
            }
            return false;
        }
    }

    static int[] toArray(int value) {
        String s = String.valueOf(value);
        int[] a = new int[s.length()];
        for (int i = 0; i < a.length; ++i)
            a[i] = s.charAt(i) - '0';
        return a;
    }

    static int solution(int N) {
        int length = 0;
        Matcher matcher = new Matcher(toArray(N));
        for (int value = 1; value <= N; ++value) {
            int[] digits = toArray(value);
            for (int i = 0; i < digits.length; ++i) {
                ++length;
                if (matcher.match(digits[i]))
                    return length - matcher.digits.length + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        System.out.println(solution(N));
    }
}
