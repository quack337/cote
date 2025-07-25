package baekjoon.b1912.old;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());
        reader.close();;

        int[][] 합 = new int[N][N];
        for (int i = 0; i < N; ++i)
            합[i][i] = A[i];
        int 최대 = Integer.MIN_VALUE;
        for (int d = 1; d < N; ++d)
            for (int i = 0; i < N-d; ++i) {
                합[i][i+d] = 합[i][i] + 합[i+1][i+d];
                if (합[i][i+d] > 최대) 최대 = 합[i][i+d];
            }
        System.out.println(최대);
    }
}