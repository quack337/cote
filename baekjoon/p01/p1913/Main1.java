package baekjoon.p01.p1913;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main1 {
    static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;

    static class Location implements Cloneable {
        int row, col, direction = 0;
        int moveCount = 0, moveCountMax = 1, turnCount = 0;

        public Location(int N) {
            if (N % 2 == 1)
                col = row = N / 2;
            else {
                row = N / 2;
                col = N / 2 - 1;
            }
        }

        public void move() {
            switch (direction) {
            case UP: --row; break;
            case RIGHT: ++col; break;
            case DOWN: ++row; break;
            case LEFT: --col; break;
            }
            ++moveCount;
            if (moveCount == moveCountMax) {
                moveCount = 0;
                direction = (direction + 1) % 4;
                ++turnCount;
                if (turnCount % 2 == 0) ++moveCountMax;
            }
        }

        @Override
        public Location clone() throws CloneNotSupportedException {
            return (Location)super.clone();
        }
    }

    static int[][] A;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        A = new int[N][N];
        Location p = new Location(N), p1 = null;
        for (int i = 1; i <= N * N; ++i) {
            A[p.row][p.col] = i;
            if (i == M) p1 = p.clone();
            p.move();
        }
        for (int[] a : A) {
            for (int i : a) {
                writer.write(String.valueOf(i));
                writer.write(" ");
            }
            writer.write("\n");
        }
        writer.write(String.valueOf(p1.row + 1));
        writer.write(" ");
        writer.write(String.valueOf(p1.col + 1));
        writer.write("\n");
        writer.close();
    }
}
