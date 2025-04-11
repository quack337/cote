package baekjoon.b1520;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    static int 행수, 열수;
    static int[][] A;

    static int 경로수(int 행, int 열) {
        if (행 == 행수-1 && 열 == 열수-1) return 1;
        int 합계 = 0;
        if (행 < 행수-1 && A[행+1][열] < A[행][열]) 합계 += 경로수(행+1, 열);
        if (열 < 열수-1 && A[행][열+1] < A[행][열]) 합계 += 경로수(행, 열+1);
        if (행 > 0 && A[행-1][열] < A[행][열]) 합계 += 경로수(행-1, 열);
        if (열 > 0 && A[행][열-1] < A[행][열]) 합계 += 경로수(행, 열-1);
        return 합계;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        행수 = Integer.parseInt(tokenizer.nextToken());
        열수 = Integer.parseInt(tokenizer.nextToken());
        A = new int[행수][열수];
        for (int r = 0; r < 행수; ++r) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 0; c < 열수; ++c)
                A[r][c] = Integer.parseInt(tokenizer.nextToken());
        }
        System.out.println(경로수(0, 0));
    }
}