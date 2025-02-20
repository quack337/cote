package baekjoon.p05.p5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main1 {
    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }

        public void print() {
            System.out.printf("%d ", value);
            if (left != null) left.print();
            if (right != null) right.print();
        }
    }

    static ArrayDeque<Integer> deque = new ArrayDeque<>();

    static Node parsePostOrder(int min, int max) {
        if (deque.size() == 0) return null;
        int value = deque.getLast();
        if (value < min || value > max) return null;
        deque.removeLast();
        System.out.println(value);
        Node node = new Node(value);
        node.right = parsePostOrder(node.value, max);
        node.left = parsePostOrder(min, node.value);
        return node;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = reader.readLine();
            if (s == null || s.trim().length() == 0) break;
            deque.addLast(Integer.parseInt(s));
        }
        Node node = parsePostOrder(Integer.MIN_VALUE, Integer.MAX_VALUE);
        node.print();
    }
}
