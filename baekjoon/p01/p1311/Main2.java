package baekjoon.p01.p1311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int N;
    static int[][] A;
    static Integer[][] DP;

    static boolean 이미선택되었나(int 선택된사람들, int 사람) {
        return ((선택된사람들 >> 사람) & 1) == 1;
    }

    static int 선택(int 선택된사람들, int 사람) {
        return 선택된사람들 | (1 << 사람);
    }

    static int 최소비용계산(int 일인덱스, int 선택된사람들) {
        if (일인덱스 == N) return 0;
        if (DP[선택된사람들][일인덱스] != null) return DP[선택된사람들][일인덱스];
        int 최소비용 = Integer.MAX_VALUE;
        for (int 사람인덱스 = 0; 사람인덱스 < N; ++사람인덱스) {
            if (이미선택되었나(선택된사람들, 사람인덱스)) continue;
            int 비용 = A[사람인덱스][일인덱스]
                      + 최소비용계산(일인덱스 + 1, 선택(선택된사람들, 사람인덱스)) ;
            if (비용 < 최소비용) 최소비용 = 비용;
        }
        return DP[선택된사람들][일인덱스] = 최소비용;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        A = new int[N][N];
        for (int r = 0; r < N; ++r) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 0; c < N; ++c)
                A[r][c] = Integer.parseInt(tokenizer.nextToken());
        }
        DP = new Integer[(int)Math.pow(2, N)][N];
        System.out.println(최소비용계산(0, 0));
    }
}
