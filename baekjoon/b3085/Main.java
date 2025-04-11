package baekjoon.b3085;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;
    static int N;

    static void swap(int r0, int c0, int r1, int c1) {
        char ch = map[r0][c0];
        map[r0][c0] = map[r1][c1];
        map[r1][c1] = ch;
    }

    static char get(boolean rowFirst, int r, int c) {
        return rowFirst ? map[r][c] : map[c][r];
    }

    static int count(boolean rowFirst) {
        int result = 0;
        for (int r = 0; r < N; ++r) {
            char ch = get(rowFirst, r, 0);
            int count = 0;
            for (int c = 0; c < N; ++c) {
                if (get(rowFirst, r, c) == ch) ++count;
                else {
                    result = Math.max(result, count);
                    ch = get(rowFirst, r, c);
                    count = 1;
                }
            }
            result = Math.max(result, count);
        }
        return result;
    }

    static int count() {
        return Math.max(count(true), count(false));
    }

    static int solution() {
        int result = 0;
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c) {
                if (r < N-1 && map[r][c] != map[r+1][c]) {
                    swap(r, c, r+1, c);
                    result = Math.max(result, count());
                    swap(r, c, r+1, c);
                }
                if (c < N-1 && map[r][c] != map[r][c+1]) {
                    swap(r, c, r, c+1);
                    result = Math.max(result, count());
                    swap(r, c, r, c+1);
                }
            }
        return result;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        map = new char[N][];
        for (int r = 0; r < N; ++r)
            map[r] = reader.readLine().toCharArray();
        System.out.println(solution());
    }
}