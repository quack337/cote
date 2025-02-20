package sw.p1954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    static int N, dr, dc, r, c;
    static int[][] A;

    static void 전진() {
        r += dr; c += dc;
    }

    static void 후진() {
        r -= dr; c -= dc;
    }

    static void 방향전환() {
        if (dc == 0) {
            dc = -dr;
            dr = 0;
        } else {
            dr = dc;
            dc = 0;
        }
    }

    static boolean 빈칸인가() {
        return 0 <= r && r < N && 0 <= c && c < N && A[r][c] == 0;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 1; t <= T; ++t) {
            N = Integer.parseInt(reader.readLine());
            A = new int[N][N];
            dr = 0; dc = 1; r = 0; c = 0;
            for (int i = 1; i <= N * N; ++i) {
                A[r][c] = i;
                전진();
                if (!빈칸인가()) {
                    후진();
                    방향전환();
                    전진();
                }
            }
            System.out.println("#" + t);
            for (int r = 0; r < N; ++r) {
                for (int c = 0; c < N; ++c)
                    System.out.printf("%d ", A[r][c]);
                System.out.println();
            }
        }
    }
}
