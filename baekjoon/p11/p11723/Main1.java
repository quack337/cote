package baekjoon.p11.p11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int S = 0;
        var builder = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            String[] a = reader.readLine().split(" ");
            int index = (a.length == 1) ? 0 : Integer.parseInt(a[1]) - 1;
            int bit = (1 << index);
            switch (a[0]) {
            case "add": S |= bit; break;
            case "remove": S &= ~bit; break;
            case "check": builder.append(((S >> index) & 1) + "\n"); break;
            case "toggle": S ^= bit; break;
            case "empty": S = 0; break;
            case "all": S = 0xFFFFF; break;
            }
        }
        System.out.println(builder);
    }
}
