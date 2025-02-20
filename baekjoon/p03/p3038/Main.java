package baekjoon.p03.p3038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static class Node {
        int value;
        Node left, right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public void preorder() {
            System.out.println(value);
            if (left != null) left.preorder();
            if (right != null) right.preorder();
        }
    }

    static void 트리값설정(Node node, boolean 트리2인가) {
        if (node.left != null) {
            node.value = node.value * 2 + (트리2인가 ? 0 : 1);
            트리값설정(node.left, 트리2인가);
            트리값설정(node.right, 트리2인가);
        }
        else node.value = node.value * 2 + (트리2인가 ? 1 : 0);
    }

    static Node 트리생성(int depth) {
        if (depth == 1) return new Node(1, null, null);
        Node 트리2 = 트리생성(depth-1);
        트리값설정(트리2, true);
        Node 트리3 = 트리생성(depth-1);
        트리값설정(트리3, false);
        return new Node(1, 트리2, 트리3);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int depth = Integer.parseInt(reader.readLine());
        Node root = 트리생성(depth);
        root.preorder();
    }
}
