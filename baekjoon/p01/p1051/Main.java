package baekjoon.p01.p1051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int R = Integer.parseInt(tokenizer.nextToken());
        int C = Integer.parseInt(tokenizer.nextToken());
        char[][] map = new char[R][];
        for (int r = 0; r < R; ++r)
            map[r] = reader.readLine().toCharArray();
        int maxSize = Math.min(R, C), answer = 1;
        for (int size = 2; size <= maxSize; ++size) {
            for (int r0 = 0; r0 <= R - size; ++r0) {
                int r1 = r0 + size - 1;
                for (int c0 = 0; c0 <= C - size; ++c0) {
                    int c1 = c0 + size - 1;
                    char ch = map[r0][c0];
                    if (map[r0][c1] != ch || map[r1][c0] != ch || map[r1][c1] != ch)
                        continue;
                    if (size > answer) answer = size;
                }
            }
        }
        System.out.println(answer * answer);
    }
}