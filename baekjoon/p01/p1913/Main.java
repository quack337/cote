package baekjoon.p01.p1913;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static class Location {
        int row, col;
        int moveCount = 0, moveCountMax = 1, turnCount = 0;

        public Location(int N) {
            col = row = N / 2;
            if (N % 2 == 0) --col;
        }

        public Location(Location p) {
            row = p.row; col = p.col;
        }

        public void move() {
            switch (turnCount % 4) {
            case 0: --row; break; // 위
            case 1: ++col; break; // 오른쪽
            case 2: ++row; break; // 아래
            case 3: --col; break; // 왼쪽
            }
            if (++moveCount == moveCountMax) {
                moveCount = 0;
                if (++turnCount % 2 == 0) ++moveCountMax;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        int[][] A = new int[N][N];
        Location p = new Location(N), p1 = null;
        for (int i = 1; i <= N * N; ++i) {
            A[p.row][p.col] = i;
            if (i == M) p1 = new Location(p);;
            p.move();
        }
        StringBuilder builder = new StringBuilder();
        for (int[] a : A) {
            for (int i : a)
                builder.append(i).append(" ");
            builder.append("\n");
        }
        builder.append(p1.row+1).append(" ").append(p1.col + 1);
        System.out.println(builder.toString());
    }
}