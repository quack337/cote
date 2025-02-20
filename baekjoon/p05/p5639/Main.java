package baekjoon.p05.p5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }

        public void print() {
            if (left != null) left.print();
            if (right != null) right.print();
            System.out.printf("%d ", value);
        }
    }

    static ArrayDeque<Integer> deque = new ArrayDeque<>();

    static Node parsePreOrder(int min, int max) {
        if (deque.size() == 0) return null;
        int value = deque.getFirst();
        if (value < min || value > max) return null;
        deque.removeFirst();
        Node node = new Node(value);
        node.left = parsePreOrder(min, node.value);
        node.right = parsePreOrder(node.value, max);
        return node;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = reader.readLine();
            if (s == null || s.trim().length() == 0) break;
            deque.addLast(Integer.parseInt(s));
        }
        Node node = parsePreOrder(Integer.MIN_VALUE, Integer.MAX_VALUE);
        node.print();
    }
}
