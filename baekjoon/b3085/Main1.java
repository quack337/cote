package baekjoon.b3085;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    static char[][] map;
    static int N;

    static void swap(int r0, int c0, int r1, int c1) {
        char ch = map[r0][c0];
        map[r0][c0] = map[r1][c1];
        map[r1][c1] = ch;
    }

    static int countX() { // X 축 방향으로 인접한 동일한 색 사탕 최대 수
        int result = 0;
        for (int r = 0; r < N; ++r) {
            char ch = map[r][0];
            int count = 0;
            for (int c = 0; c < N; ++c) {
                if (map[r][c] == ch) ++count;
                else {
                    result = Math.max(result, count);
                    ch = map[r][c];
                    count = 1;
                }
            }
            result = Math.max(result, count);
        }
        return result;
    }

    static int countY() { // Y 축 방향으로 인접한 동일한 색 사탕 최대 수
        int result = 0;
        for (int c = 0; c < N; ++c) {
            char ch = map[0][c];
            int count = 0;
            for (int r = 0; r < N; ++r) {
                if (map[r][c] == ch) ++count;
                else {
                    result = Math.max(result, count);
                    ch = map[r][c];
                    count = 1;
                }
            }
            result = Math.max(result, count);
        }
        return result;
    }

    static int solution() {
        int result = 0;
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c) {
                if (r < N-1 && map[r][c] != map[r+1][c]) { // 서로 다른 색이면
                    swap(r, c, r+1, c); // 교환하고
                    result = Math.max(result, countX()); // 최대 수 계산
                    result = Math.max(result, countY()); // 최대 수 계산
                    swap(r, c, r+1, c); // 교환 취소
                }
                if (c < N-1 && map[r][c] != map[r][c+1]) {
                    swap(r, c, r, c+1);
                    result = Math.max(result, countX());
                    result = Math.max(result, countY());
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