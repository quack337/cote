package baekjoon.p16.p16926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {

    static final int ROW = 0, COL = 1;
    static int row_size, col_size;

    static void rotate(int no, int[] p, int rotate) {
        final int row2 = row_size - no - 1;
        final int col2 = col_size - no - 1;

        for (int i = 0; i < rotate; ++i)
            if (p[COL] == no && p[ROW] < row2) p[ROW]++; // 아래로 이동
            else if (p[ROW] == row2 && p[COL] < col2) p[COL]++; // 오른쪽으로 이동
            else if (p[COL]== col2 && p[ROW] > no) p[ROW]--; // 위로 이동
            else if (p[ROW]== no && p[COL] > no) p[COL]--; // 왼쪽으로 이동
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        row_size = Integer.parseInt(tokenizer.nextToken());
        col_size = Integer.parseInt(tokenizer.nextToken());
        int R = Integer.parseInt(tokenizer.nextToken());

        int[][] A = new int[row_size][col_size];
        for (int r = 0; r < row_size; ++r) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 0; c < col_size; ++c)
                A[r][c] = Integer.parseInt(tokenizer.nextToken());
        }
        int[][] B = new int[row_size][col_size];
        for (int no = 0; no < Math.min(row_size, col_size) / 2; ++no) {
            int no_rect_size = row_size * 2 + col_size * 2 - no * 8 - 4;
            int[] a = new int[] {no, no};
            int[] b = new int[] {no, no};
            rotate(no, b, R % no_rect_size);
            for (int i = 0; i < no_rect_size; ++i) {
                B[b[ROW]][b[COL]] = A[a[ROW]][a[COL]];
                rotate(no, a, 1);
                rotate(no, b, 1);
            }
        }
        var builder = new StringBuilder();
        for (int r = 0; r < row_size; ++r) {
            for (int c = 0; c < col_size; ++c) {
                builder.append(B[r][c]);
                builder.append(c == col_size - 1 ? "\n" : " ");
            }
        }
        System.out.println(builder.toString());
    }
}
