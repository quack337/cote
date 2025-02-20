package baekjoon.p07.p7569;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int BFS(int[][][] A, ArrayList<int[]> 익은_목록, int 익지않은_수) {
        int max_row = A.length - 1, max_col = A[0].length - 1, max_hig = A[0][0].length - 1;
        var queue = new ArrayDeque<int[]>();
        queue.addAll(익은_목록);
        while (queue.size() > 0) {
            int[] current = queue.remove();
            int row = current[0], col = current[1], hig = current[2], distance = current[3];
            if (A[row][col][hig] == -1) continue;
            if (A[row][col][hig] == 0) --익지않은_수;
            if (익지않은_수 == 0) return distance;
            A[row][col][hig] = -1;
            if (row > 0) queue.add(new int[] { row-1, col, hig, distance+1 });
            if (col > 0) queue.add(new int[] { row, col-1, hig, distance+1 });
            if (hig > 0) queue.add(new int[] { row, col, hig-1, distance+1 });
            if (row < max_row) queue.add(new int[] { row+1, col, hig, distance+1 });
            if (col < max_col) queue.add(new int[] { row, col+1, hig, distance+1 });
            if (hig < max_hig) queue.add(new int[] { row, col, hig+1, distance+1 });
        }
        return -1;
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int H = scanner.nextInt();
        int 익지않은_수 = 0;
        var 익은_목록 = new ArrayList<int[]>();
        var A = new int[N][M][H];
        for (int h = 0; h < H; ++h)
            for (int r = 0; r < N; ++r)
                for (int c = 0; c < M; ++c) {
                    A[r][c][h] = scanner.nextInt();
                if (A[r][c][h] == 0) ++익지않은_수;
                else if (A[r][c][h] == 1) 익은_목록.add(new int[] {r, c, h, 0});
            }
        System.out.println(BFS(A, 익은_목록, 익지않은_수));
        scanner.close();
    }
}
