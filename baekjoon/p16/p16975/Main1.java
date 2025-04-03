package baekjoon.p16.p16975;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    static class Node {
        long value;
        Node left, right;
    }

    static Node createTree(int start, int end) {
        Node node = new Node();
        if (start == end)
            return node;
        else {
            int middle = (start + end) / 2;
            node.left = createTree(start, middle);
            node.right = createTree(middle + 1, end);
            return node;
        }
    }

    static void add(Node node, int value, int from, int to, int start, int end) {
        if (from == start && to == end)
            node.value += value;
        else {
            int middle = (start + end) / 2;
            if (to <= middle) add(node.left, value, from, to, start, middle);
            else if (from > middle) add(node.right, value, from, to, middle + 1, end);
            else {
                add(node.left, value, from, middle, start, middle);
                add(node.right, value, middle + 1, to, middle + 1, end);
            }
        }
    }

    static long get(Node node, int index, int start, int end) {
        if (start == end)
            return node.value;
        else {
            int middle = (start + end) / 2;
            if (index <= middle) return node.value + get(node.left, index, start, middle);
            else return node.value + get(node.right, index, middle + 1, end);
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] A = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());
        Node root = createTree(0, N-1);
        int M = Integer.parseInt(reader.readLine());
        var builder = new StringBuilder();
        for (int i = 0; i < M; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int q = Integer.parseInt(tokenizer.nextToken());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            if (q == 1) {
                int b = Integer.parseInt(tokenizer.nextToken()) - 1;
                int v = Integer.parseInt(tokenizer.nextToken());
                add(root, v, a, b, 0, N - 1);
            } else {
                long answer = A[a] + get(root, a, 0, N - 1);
                builder.append(answer + "\n");
            }
        }
        System.out.println(builder.toString());
    }
}