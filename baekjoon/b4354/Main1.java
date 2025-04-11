package baekjoon.b4354;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {

    static int[] kmpPattern(char[] s) {
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

    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var builder = new StringBuilder();
        while (true) {
            char[] A = reader.readLine().toCharArray();
            if (A.length == 1 && A[0] == '.') break;
            int[] p = kmpPattern(A);
            int size = p.length - p[p.length-1];
            int answer = 1;
            if (p.length % size == 0 && p.length / size > 1)
                answer = p.length / size;
            builder.append(answer + "\n");
        }
        System.out.println(builder.toString());
    }
}