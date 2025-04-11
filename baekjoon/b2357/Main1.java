package baekjoon.b2357;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    static int[] A;

    static class Node {
        int min, max;
        Node left, right;
    }

    static Node createTree(int start, int end) {
        Node node = new Node();
        if (start == end)
            node.min = node.max = A[start];
        else {
            int middle = (start + end) / 2;
            node.left = createTree(start, middle);
            node.right = createTree(middle + 1, end);
            node.min = Math.min(node.left.min, node.right.min);
            node.max = Math.max(node.left.max, node.right.max);
        }
        return node;
    }

    static Node minmax(Node node, int from, int to, int start, int end) {
        if (from == start && to == end)
            return node;
        else {
            int middle = (start + end) / 2;
            if (to <= middle) return minmax(node.left, from, to, start, middle);
            if (from > middle) return minmax(node.right, from, to, middle + 1, end);
            Node node1 = minmax(node.left, from, middle, start, middle);
            Node node2 = minmax(node.right, middle + 1, to, middle + 1, end);
            Node result = new Node();
            result.min = Math.min(node1.min, node2.min);
            result.max = Math.max(node1.max, node2.max);
            return result;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        A = new int[N];
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(reader.readLine());
        Node root = createTree(0, N-1);
        var builder = new StringBuilder();
        for (int i = 0; i < M; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            Node node = minmax(root, a - 1, b - 1, 0, N - 1);
            builder.append(node.min + " ").append(node.max + "\n");
        }
        System.out.println(builder.toString());
    }
}