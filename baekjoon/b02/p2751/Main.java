package baekjoon.b02.p2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        byte[] count = new byte[2000000 + 1];
        for (int i = 0; i < N; ++i) {
            int value = Integer.parseInt(reader.readLine());
            count[value + 1000000] = 1; // count 값은 0 아니면 1
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count.length; ++i)
            if (count[i] == 1) // count 값은 0 아니면 1
                builder.append(i - 1000000).append('\n');
        System.out.println(builder.toString());
    }
}