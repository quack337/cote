package baekjoon.p02.p2580;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    static int[][] A;

    static boolean 채우기(ArrayList<int[]> 빈칸목록, int index) {
        if (index >= 빈칸목록.size()) return true;
        int[] 빈칸 = 빈칸목록.get(index);
        int row = 빈칸[0], col = 빈칸[1];
        boolean[] 사용됨 = new boolean[10];
        사용된수_찾기(row, col, 사용됨);
        for (int i = 1; i <= 9; ++i)
            if (사용됨[i] == false) {
                A[row][col] = i;
                if (채우기(빈칸목록, index + 1)) return true;
            }
        A[row][col] = 0;
        return false;
    }

    static void 사용된수_찾기(int row, int col, boolean[] numbers) {
        for (int i = 0; i < 9; ++i) {
            numbers[A[row][i]] = true;
            numbers[A[i][col]] = true;
        }
        int row0 = row/3 * 3, col0 = col/3 * 3;
        for (int r = 0; r < 3; ++r)
            for (int c = 0; c < 3; ++c)
                numbers[A[row0 + r][col0 + c]] = true;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        A = new int[9][9];
        var 빈칸목록 = new ArrayList<int[]>();
        for (int r = 0; r < 9; ++r) {
            for (int c = 0; c < 9; ++c) {
                A[r][c] = scanner.nextInt();
                if (A[r][c] == 0) 빈칸목록.add(new int[] {r, c});
            }
        }
        scanner.close();
        채우기(빈칸목록, 0);
        for (int r = 0; r < 9; ++r)
            for (int c = 0; c < 9; ++c)
                System.out.print(A[r][c] + (c < 8 ? " " : "\n"));
    }
}