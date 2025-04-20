package baekjoon.b11505;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    static int[] A;
    static int N;

    static class Node {
        long value;
        Node left, right;
    }

    static Node createTree(int start, int end) {
        Node node = new Node();
        if (start == end)
            node.value = A[start];
        else {
            int middle = (start + end) / 2;
            node.left = createTree(start, middle);
            node.right = createTree(middle + 1, end);
            node.value = (node.left.value * node.right.value) % 1_000_000_007;
        }
        return node;
    }

    static void updateTree(Node node, int index, int newValue, int start, int end) {
        if (start == end)
            node.value = newValue;
        else {
            int middle = (start + end) / 2;
            if (index <= middle) updateTree(node.left, index, newValue, start, middle);
            else updateTree(node.right, index, newValue, middle + 1, end);
            node.value = (node.left.value * node.right.value) % 1_000_000_007;
        }
    }

    static long 구간곱(Node node, int from, int to, int start, int end) {
        if (from == start && to == end)
            return node.value;
        else {
            int middle = (start + end) / 2;
            if (to <= middle) return 구간곱(node.left, from, to, start, middle);
            if (from > middle) return 구간곱(node.right, from, to, middle + 1, end);
            return (구간곱(node.left, from, middle, start, middle) *
                    구간곱(node.right, middle + 1, to, middle + 1, end)) % 1_000_000_007;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        final int M = Integer.parseInt(tokenizer.nextToken());
        final int K = Integer.parseInt(tokenizer.nextToken());
        A = new int[N];
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(reader.readLine());
        Node root = createTree(0, N - 1);
        var builder = new StringBuilder();
        for (int i = 0; i < M + K; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());
            if (a == 1) {
                updateTree(root, b - 1, c, 0, N-1);
                A[b - 1] = c;
            }
            else if (a == 2) builder.append(구간곱(root, b - 1, c - 1, 0, N-1) + "\n");
        }
        System.out.println(builder.toString());
    }
}