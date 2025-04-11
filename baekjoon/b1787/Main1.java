package baekjoon.b1787;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {

    static int[] kmpPattern(char[] s, int end) {
        int[] p = new int[end];
        int J = 0;
        for (int i = 1; i < end; ++i) {
            while (J > 0 && s[i] != s[J])
                J = p[J - 1];
            if (s[i] == s[J]) {
                ++J;
                p[i] = J;
            }
        }
        return p;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String S = reader.readLine();
        char[] A = S.toCharArray();
        int Psum = 0;
        for (int i = 1; i <= N; ++i) {
            int[] p = kmpPattern(A, i);
            int J = p[i - 1];
            while (J > 0 && p[J - 1] > 0)
                J = p[J - 1];
            if (J > 0) Psum += (i - J);
        }
        System.out.println(Psum);
    }
}