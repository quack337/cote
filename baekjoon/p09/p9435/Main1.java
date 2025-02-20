package baekjoon.p09.p9435;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {

    static class Node {
        int min, max;
        Node left, right;
    }

    static Node createTree(int start, int end) {
        Node node = new Node();
        if (start == end)
            node.min = node.max = start;
        else {
            int middle = (start + end) / 2;
            node.left = createTree(start, middle);
            node.right = createTree(middle + 1, end);
            node.min = Math.min(node.left.min, node.right.min);
            node.max = Math.max(node.left.max, node.right.max);
        }
        return node;
    }

    static void updateTree(Node node, int index, int newValue, int start, int end) {
        if (start == end)
            node.min = node.max = newValue;
        else {
            int middle = (start + end) / 2;
            if (index <= middle) updateTree(node.left, index, newValue, start, middle);
            else updateTree(node.right, index, newValue, middle + 1, end);
            node.min = Math.min(node.left.min, node.right.min);
            node.max = Math.max(node.left.max, node.right.max);
        }
    }

    static Node getNode(Node node, int from, int to, int start, int end) {
        if (from == start && to == end)
            return node;
        else {
            int middle = (start + end) / 2;
            if (to <= middle) return getNode(node.left, from, to, start, middle);
            if (from > middle) return getNode(node.right, from, to, middle + 1, end);
            Node result = new Node();
            Node node1 = getNode(node.left, from, middle, start, middle);
            Node node2 = getNode(node.right, middle + 1, to, middle + 1, end);
            result.min = Math.min(node1.min, node2.min);
            result.max = Math.max(node1.max, node2.max);
            return result;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        var builder = new StringBuilder();
        for (int t = 0; t < T; ++t) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(tokenizer.nextToken());
            int K = Integer.parseInt(tokenizer.nextToken());
            int[] A = new int[N];
            for (int i = 0; i < N; ++i) A[i] = i;
            Node root = createTree(0, N-1);
            for (int k = 0; k < K; ++k) {
                tokenizer = new StringTokenizer(reader.readLine());
                int q = Integer.parseInt(tokenizer.nextToken());
                int a = Integer.parseInt(tokenizer.nextToken());
                int b = Integer.parseInt(tokenizer.nextToken());
                if (q == 0) {
                    updateTree(root, a, A[b], 0, N-1);
                    updateTree(root, b, A[a], 0, N-1);
                    int temp = A[a]; A[a] = A[b]; A[b] = temp;
                } else {
                    Node node = getNode(root, a, b, 0, N-1);
                    boolean answer = (node.min == a) && (node.max == b);
                    builder.append(answer ? "YES\n" : "NO\n");
                }
            }
        }
        System.out.println(builder.toString());
    }
}
