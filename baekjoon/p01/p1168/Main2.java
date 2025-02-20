package baekjoon.p01.p1168;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

public class Main2 {

    static int[] node;

    static void create(int nodeIndex, int start, int end) {
        if (start > end) return;
        if (start == end) {
            node[nodeIndex] = 1; // A 배열에 1만 들어있으므로, A 배열을 만들 필요 없다.
            return;
        }
        int middle = (start + end) / 2;
        int left = nodeIndex * 2, right = nodeIndex * 2 + 1;
        create(left, start, middle);
        create(right, middle + 1, end);
        node[nodeIndex] = node[left] + node[right];
    }

    static int sum(int nodeIndex, int start, int end, int from, int to) {
        if (start == from && end == to) return node[nodeIndex];
        int middle = (start + end) / 2;
        int left = nodeIndex * 2, right = nodeIndex * 2 + 1;
        if (to <= middle) return sum(left, start, middle, from, to);
        else if (middle + 1 <= from) return sum(right, middle + 1, end, from, to);
        return sum(left, start, middle, from, middle) +
               sum(right, middle + 1, end, middle + 1, to);
    }

    static void update(int nodeIndex, int start, int end, int index, int diff) {
        node[nodeIndex] += diff;
        if (start == end) return;
        int middle = (start + end) / 2;
        int left = nodeIndex * 2, right = nodeIndex * 2 + 1;
        if (index <= middle) update(left, start, middle, index, diff);
        else update(right, middle + 1, end, index, diff);
    }

    static int findTo2(int from, int N, int K) {
        if (sum(1, 0, N-1, from, N-1) >= K)
            return findTo1(from, N, K);
        K -= sum(1, 0, N-1, from, N-1);
        while (K > sum(1, 0, N-1, 0, N-1))
            K -= sum(1, 0, N-1, 0, N-1);
        return findTo1(0, N, K);
    }

    static int findTo1(int from, int N, int K) {
        int to1 = from + 1, to2 = N-1;
        while (true) {
            int middle = (to2 + to1) / 2;
            int s = sum(1, 0, N-1, from, middle);
            if (s > K) middle = to2 = middle - 1;
            else if (s < K) to1 = middle + 1;
            else {
                if (sum(1, 0, N-1, middle, middle) == 0)
                    to2 = middle - 1;
                else
                    return middle;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            node = new int[N * 4];
            create(1, 0, N-1);

            Writer writer = new BufferedWriter(new OutputStreamWriter(System.out));
            writer.write("<");
            boolean first = true;
            int index = 0;
            for (int i = 0; i < N; ++i) {
                index = findTo2(index, N, K);
                if (!first) writer.write(", ");
                else first = false;
                writer.write(String.valueOf(index + 1));
                update(1, 0, N-1, index, -1);
            }
            writer.write(">");
            writer.close();
        }
    }
}
