package baekjoon.b02.p2580;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static final int N = 9;
    static int[][] A;

    static class Point { // 빈칸 좌표
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static ArrayList<Integer> createNumbers() { // 1~9 숫자 목록 생성
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; ++i)
            numbers.add(i);
        return numbers;
    }

    static boolean 채우기(ArrayList<Point> zeros, int index) {
        if (index >= zeros.size()) return true;
        Point p = zeros.get(index);
        ArrayList<Integer> numbers = createNumbers();
        경우의수_줄이기(p.row, p.col, numbers);
        for (int i : numbers) {
            A[p.row][p.col] = i;
            if (채우기(zeros, index + 1)) return true;
        }
        A[p.row][p.col] = 0;
        return false;
    }

    static void 경우의수_줄이기(int row, int col, ArrayList<Integer> numbers) {
        for (int i = 0; i < N; ++i) {
            numbers.remove((Integer)A[row][i]);
            numbers.remove((Integer)A[i][col]);
        }
        int row0 = row/3 * 3, col0 = col/3 * 3;
        for (int r = 0; r < 3; ++r)
            for (int c = 0; c < 3; ++c)
                numbers.remove((Integer)A[row0 + r][col0 + c]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        A = new int[N][N];
        ArrayList<Point> zeros = new ArrayList<Point>();
        for (int r = 0; r < N; ++r) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 0; c < N; ++c) {
                A[r][c] = Integer.parseInt(tokenizer.nextToken());
                if (A[r][c] == 0) zeros.add(new Point(r, c));
            }
        }
        채우기(zeros, 0);
        StringBuilder builder = new StringBuilder();
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c)
                builder.append(A[r][c]).append(' ');
            builder.append('\n');
        }
        System.out.println(builder.toString());
    }
}