package baekjoon.p01.p1022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Location {
        int row, col;
        int moveCount = 0, moveCountMax = 1, turnCount = 0;

        public Location(int N) {
            col = row = N / 2;
            if (N % 2 == 0) --col;
        }

        public void move() {
            switch (turnCount % 4) {
            case 0: ++col; break; // 오른쪽
            case 1: --row; break; // 위
            case 2: --col; break; // 왼쪽
            case 3: ++row; break; // 아래
            }
            if (++moveCount == moveCountMax) {
                moveCount = 0;
                if (++turnCount % 2 == 0) ++moveCountMax;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int r1 = Integer.parseInt(tokenizer.nextToken());
        int c1 = Integer.parseInt(tokenizer.nextToken());
        int r2 = Integer.parseInt(tokenizer.nextToken());
        int c2 = Integer.parseInt(tokenizer.nextToken());
        int d = Math.max(Math.max(Math.abs(r1), Math.abs(c1)), Math.max(Math.abs(r2), Math.abs(c2)));
        int N = d * 2 + 1;
        int[][] A = new int[r2-r1+1][c2-c1+1];
        r1 += d; c1 += d; r2 += d; c2 += d;
        Location p = new Location(N);
        int max = 0;
        for (int i = 1; i <= N * N; ++i) {
            if (r1 <= p.row && p.row <= r2 && c1 <= p.col && p.col <= c2) {
                A[p.row - r1][p.col - c1] = i;
                if (i > max) max = i;
            }
            p.move();
        }
        String formatString = "%" + String.valueOf(max).length() + "d ";
        StringBuilder builder = new StringBuilder();
        for (int[] a : A) {
            for (int i : a)
                builder.append(String.format(formatString, i));
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }
}