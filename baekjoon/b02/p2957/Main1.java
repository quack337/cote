package baekjoon.b02.p2957;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main1 {
    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }
    }

    static int count;
    static Node root;

    static void insert(int x, Node node) {
        ++count;
        if (x < node.value) {
            if (node.left == null) node.left = new Node(x);
            else insert(x, node.left);
        } else if (x > node.value) {
            if (node.right == null) node.right = new Node(x);
            else insert(x, node.right);
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(reader.readLine());
        root = new Node(Integer.parseInt(reader.readLine()));
        writer.append("0\n");
        for (int i = 1; i < N; ++i) {
            int a = Integer.parseInt(reader.readLine());
            insert(a, root);
            writer.append(String.valueOf(count));
            writer.append('\n');
        }
        reader.close();
        writer.close();
    }
}