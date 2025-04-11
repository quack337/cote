package baekjoon.b6549;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
    static class Node {
        long value;
        int index;
        Node left, right;
    }

    static Node createTree(long[] a, int start, int end) {
        if (start > end) return new Node();
        if (start == end) {
            Node node = new Node();
            node.value = a[start];
            node.index = start;
            return node;
        }
        int middle = (start + end) / 2;
        Node node = new Node();
        node.left = createTree(a, start, middle);
        node.right = createTree(a, middle + 1, end);
        node.value = Math.min(node.left.value, node.right.value);
        node.index = (node.value == node.left.value) ? node.left.index : node.right.index;
        return node;
    }

    static Node findMin(Node node, int start, int end, int from, int to) {
        if (start == from && end == to) return node;
        int middle = (start + end) / 2;
        if (to <= middle) return findMin(node.left, start, middle, from, to);
        else if (middle + 1 <= from) return findMin(node.right, middle + 1, end, from, to);
        Node min1 = findMin(node.left, start, middle, from, middle);
        Node min2 = findMin(node.right, middle + 1, end, middle + 1, to);
        return min1.value < min2.value ? min1 : min2;
    }

    static Node root;
    static int N;
    static long[] A;

    static long solution(int from, int to) {
        if (from > to) return 0;
        Node min = findMin(root, 0, N-1, from, to);
        long 면적1 = min.value * (to - from + 1);
        long 면적2 = solution(from, min.index - 1);
        long 면적3 = solution(min.index + 1, to);
        return Math.max(면적1, Math.max(면적2, 면적3));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            N = Integer.parseInt(tokenizer.nextToken());
            if (N == 0) break;
            A = new long[N];
            for (int i = 0; i < N; ++i)
                A[i] = Integer.parseInt(tokenizer.nextToken());
            root = createTree(A, 0, N-1);
            System.out.println(solution(0, N-1));
        }
        reader.close();
    }
}