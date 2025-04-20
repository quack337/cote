package baekjoon.b11049;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    static int[][] A;
    static int N;

    static int 곱셈횟수(int start, int end) {
        if (start == end) return 0;
        int min = Integer.MAX_VALUE;
        for (int i = start; i < end; ++i) {
            int n1 = 곱셈횟수(start, i);
            int n2 = 곱셈횟수(i + 1, end);
            int n3 = A[start][0] * A[i][1] * A[end][1];
            min = Math.min(min, n1 + n2 + n3);
        }
        return min;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        A = new int[N][2];
        for (int i = 0; i < N; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            A[i][0] = Integer.parseInt(tokenizer.nextToken());
            A[i][1] = Integer.parseInt(tokenizer.nextToken());
        }
        System.out.println(곱셈횟수(0, N-1));
    }
}