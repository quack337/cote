package baekjoon.p09.p9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean VPS(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') ++count;
            else if (c == ')') --count;
            if (count < 0) return false;
        }
        return count == 0;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int N = Integer.parseInt(reader.readLine());
        for (int i = 0; i < N; i++) {
            String s = reader.readLine();
            builder.append(VPS(s) ? "YES" : "NO").append('\n');
        }
        System.out.println(builder.toString());
    }
}