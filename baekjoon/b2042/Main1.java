package baekjoon.b2042;
import java.io.IOException;
import java.util.Scanner;

public class Main1 {

    static long[] node;

    static long sum(int nodeIndex, int start, int end, int from, int to) {
        if (start == from && end == to) return node[nodeIndex];
        int middle = (start + end) / 2;
        int left = nodeIndex * 2, right = nodeIndex * 2 + 1;
        if (to <= middle) return sum(left, start, middle, from, to);
        else if (middle + 1 <= from) return sum(right, middle + 1, end, from, to);
        return sum(left, start, middle, from, middle) +
               sum(right, middle + 1, end, middle + 1, to);
    }

    static void update(int nodeIndex, int start, int end, int index, long diff) {
        node[nodeIndex] += diff;
        if (start == end) return;
        int middle = (start + end) / 2;
        int left = nodeIndex * 2, right = nodeIndex * 2 + 1;
        if (index <= middle) update(left, start, middle, index, diff);
        else update(right, middle + 1, end, index, diff);
    }

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int K = scanner.nextInt();
            node = new long[N * 4];
            for (int i = 0; i < N; ++i)
                update(1, 0, N-1, i, scanner.nextLong());
            for (int i = 0; i < M + K; ++i) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                long c = scanner.nextLong();
                if (a == 1)
                    update(1, 0, N-1, b-1, c - sum(1, 0, N-1, b-1, b-1));
                else
                    System.out.println(sum(1, 0, N-1, b-1, (int)(c-1)));
            }
        }
    }
}