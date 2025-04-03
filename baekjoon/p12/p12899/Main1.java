package baekjoon.p12.p12899;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {

    static class Node {
        int count;
        Node left, right;
    }

    static void add(Node node, int index, int start, int end) {
        node.count++;
        if (start != end) {
            int middle = (start + end) / 2;
            if (index <= middle) {
                if (node.left == null) node.left = new Node();
                add(node.left, index, start, middle);
            } else {
                if (node.right == null) node.right = new Node();
                add(node.right, index, middle + 1, end);
            }
        }
    }

    static int remove(Node node, int nth, int start, int end) {
        node.count--;
        if (start == end)
            return start;
        int middle = (start + end) / 2;
        if (node.left != null && nth <= node.left.count)
            return remove(node.left, nth, start, middle);
        nth -= (node.left == null ? 0 : node.left.count);
        return remove(node.right, nth, middle + 1, end);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        Node root = new Node();
        var builder = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int q = Integer.parseInt(tokenizer.nextToken());
            int x = Integer.parseInt(tokenizer.nextToken());
            if (q == 1)
                add(root, x, 0, 2_000_000);
            else {
                int value = remove(root, x, 0, 2_000_000);
                builder.append(value + "\n");
            }
        }
        System.out.println(builder.toString());
    }
}