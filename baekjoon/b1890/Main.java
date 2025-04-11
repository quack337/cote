package baekjoon.b1890;
import java.util.Scanner;

public class Main {
    static byte[][] 게임판;
    static long[][] 경로수;

    static long DFS(int 행, int 열) {
        if (행 < 0 || 행 >= 게임판.length) return 0;
        if (열 < 0 || 열 >= 게임판[0].length) return 0;
        if (경로수[행][열] > -1) return 경로수[행][열];
        if (행 == 게임판.length - 1 && 열 == 게임판[0].length - 1) return 1;
        int 점프 = 게임판[행][열];
        if (점프 == 0) return 0;
        return 경로수[행][열] = DFS(행 + 점프, 열) + DFS(행, 열 + 점프);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            게임판 = new byte[N][N];
            경로수 = new long[N][N];
            for (int r = 0; r < N; ++r)
                for (int c = 0; c < N; ++c) {
                    게임판[r][c] = scanner.nextByte();
                    경로수[r][c] = -1;
                }
            System.out.println(DFS(0, 0));
        }
    }
}