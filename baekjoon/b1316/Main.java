package baekjoon.b1316;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean isGroupWord(String s) {
        boolean[] b = new boolean['z' - 'a' + 1];
        char prev = ' ';
        for (char c : s.toCharArray()) {
            if (c == prev) continue; // 직전 문자와 동일하면 ok
            int index = c - 'a';
            if (b[index]) return false; // 앞에서 나왔던 문자라면 false
            b[index] = true;
            prev = c;
        }
        return true;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int count = 0;
        for (int i = 0; i < N; ++i)
            if (isGroupWord(reader.readLine()))
                ++count;
        System.out.println(count);
    }
}