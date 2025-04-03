package baekjoon.p07.p7576;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {

    static int BFS(int[][] A, ArrayList<int[]> 익은_목록, int 익지않은_수) {
        int max_row = A.length - 1, max_col = A[0].length - 1;
        var queue = new ArrayDeque<int[]>();
        queue.addAll(익은_목록);
        while (queue.size() > 0) {
            int[] current = queue.remove();
            int row = current[0], col = current[1], distance = current[2];
            if (A[row][col] == -1) continue;
            if (A[row][col] == 0) --익지않은_수;
            if (익지않은_수 == 0) return distance;
            A[row][col] = -1;
            if (row > 0) queue.add(new int[] { row-1, col, distance+1 });
            if (col > 0) queue.add(new int[] { row, col-1, distance+1 });
            if (row < max_row) queue.add(new int[] { row+1, col, distance+1 });
            if (col < max_col) queue.add(new int[] { row, col+1, distance+1 });
        }
        return -1;
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int 익지않은_수 = 0;
        var 익은_목록 = new ArrayList<int[]>();
        var A = new int[N][M];
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < M; ++c) {
                A[r][c] = scanner.nextInt();
                if (A[r][c] == 0) ++익지않은_수;
                else if (A[r][c] == 1) 익은_목록.add(new int[] {r, c, 0});
            }
        System.out.println(BFS(A, 익은_목록, 익지않은_수));
        scanner.close();
    }
}