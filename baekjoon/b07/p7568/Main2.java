package baekjoon.b07.p7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        final int W = 0, H = 1, R = 2;
        var A = new int[N][];
        for (int i = 0; i < N; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int w = Integer.parseInt(tokenizer.nextToken());
            int h = Integer.parseInt(tokenizer.nextToken());
            A[i] = new int[] {w, h, 0};
        }
        var B = Arrays.copyOf(A, N);
        Comparator<int[]> comparator = (a, b) -> {
            int r1 = b[W] - a[W];
            int r2 = b[H] - a[H];
            if ((r1 >= 0 && r2 >= 0) || (r1 <= 0 && r2 <= 0))
                return r1 + r2;
            return 0;
        };
        Arrays.sort(B, comparator);
        int rank = 1;
        B[0][R] = rank;
        for (int i = 1; i < N; ++i) {
            if (comparator.compare(B[i], B[i - 1]) > 0)
                rank = i + 1;
            B[i][R] = rank;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; ++i)
            builder.append(A[i][R]).append(' ');
        System.out.println(builder.toString());
    }
}