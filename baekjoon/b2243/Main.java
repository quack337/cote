package baekjoon.b2243;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int[] node;

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

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            final int MAX = 1_000_000;
            node = new int[MAX * 4];
            int N = scanner.nextInt();
            for (int i = 0; i < N; ++i) {
                int a = scanner.nextInt();
                if (a == 1) {
                    int b = scanner.nextInt();
                    int start = 0, end = MAX-1, answer = 0;
                    while (start <= end) {
                        int middle = (start + end) / 2;
                        int count = sum(1, 0, MAX-1, 0, middle);
                        if (count >= b) {
                            end = middle - 1;
                            answer = middle;
                        } else
                            start = middle + 1;
                    }
                    update(1, 0, MAX-1, answer, -1);
                    System.out.println(answer+1);
                } else {
                    int b = scanner.nextInt() - 1;
                    int c = scanner.nextInt();
                    update(1, 0, MAX-1, b, c);
                }
            }
        }
    }
}