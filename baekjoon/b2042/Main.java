package baekjoon.b2042;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static long[] A, node;

    static void create(int nodeIndex, int start, int end) {
        if (start > end) return;
        if (start == end) {
            node[nodeIndex] = A[start];
            return;
        }
        int middle = (start + end) / 2;
        int left = nodeIndex * 2, right = nodeIndex * 2 + 1;
        create(left, start, middle);
        create(right, middle + 1, end);
        node[nodeIndex] = node[left] + node[right];
    }

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
            A = new long[N];
            for (int i = 0; i < N; ++i)
                A[i] = scanner.nextLong();
            node = new long[N * 4];
            create(1, 0, N-1);
            for (int i = 0; i < M + K; ++i) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                long c = scanner.nextLong();
                if (a == 1) {
                    update(1, 0, N-1, b-1, c - A[b-1]);
                    A[b - 1] = c;
                } else
                    System.out.println(sum(1, 0, N-1, b-1, (int)(c-1)));
            }
        }
    }
}