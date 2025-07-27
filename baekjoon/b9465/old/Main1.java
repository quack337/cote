package baekjoon.b9465.old;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    static int N;
    static int[][] A;

    static int 최대점수(int index, int previous) {
        if (index >= N) return 0;
        int 최대값 = 0;
        for (int r = 0; r <= 2; ++r)
            if (r == 0 || r != previous) {
                int 점수 = A[r][index] + 최대점수(index + 1, r);
                if (점수 > 최대값) 최대값 = 점수;
            }
        return 최대값;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; ++t) {
            N = Integer.parseInt(reader.readLine());
            A = new int[3][N];
            for (int r = 1; r <= 2; ++r) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int c = 0; c < N; ++c)
                    A[r][c] = Integer.parseInt(tokenizer.nextToken());
            }
            System.out.println(최대점수(0, 0));
        }
    }
}