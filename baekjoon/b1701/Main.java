package baekjoon.b1701;
import java.util.Scanner;

public class Main {
    static int max = 0;

    // s 문자열의 start에서 부터 시작하는 부분 문자열에 대해서
    // kmp 테이블을 만든다.
    static int[] kmpPattern(char[] s, int start) {
        int[] p = new int[s.length - start];
        int J = 0;
        for (int i = 1; i < s.length - start; ++i) {
            while (J > 0 && s[i + start] != s[J + start])
                J = p[J - 1];
            if (s[i + start] == s[J + start]) {
                ++J;
                p[i] = J;
                if (J > max) max = J; // 최대값을 찾는다
            }
        }
        return p;
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        char[] A = scanner.next().toCharArray();
        for (int i = 0; i < A.length - max - 1; ++i)
            kmpPattern(A, i);
        System.out.println(max);
    }
}