package baekjoon.p02.p2809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static int A_SIZE = 26;
    static Node root;

    static class Node {
        Node[] go = new Node[A_SIZE];
        Node fail;
        int out = 0;
    }

    static void buildMatcher(char[][] words) {
        root = new Node();
        for (int i = 0; i < words.length; ++i) {
            Node node = root;
            for (char ch : words[i]) {
                int ci = ch - 'a';
                if (node.go[ci] == null) node.go[ci] = new Node();
                node = node.go[ci];
            }
            node.out = words[i].length;
        }
        var queue = new ArrayDeque<Node>();
        root.fail = root;
        for (int ci = 0; ci < A_SIZE; ++ci)
            if (root.go[ci] == null) root.go[ci] = root;
            else {
                root.go[ci].fail = root;
                queue.add(root.go[ci]);
            }
        while (queue.size() > 0) {
            Node node = queue.remove();
            for (int ci = 0; ci < A_SIZE; ++ci)
                if (node.go[ci] != null) {
                    Node nextNode = node.go[ci], failNode = node.fail;
                    while (failNode.go[ci] == null)
                        failNode = failNode.fail;
                    nextNode.fail = failNode.go[ci];
                    nextNode.out = Math.max(nextNode.out, nextNode.fail.out);
                    queue.add(nextNode);
                }
        }
    }

    static Node nextNode(Node node, char ch) {
        int ci = ch - 'a';
        while (node.go[ci] == null)
            node = node.fail;
        return node.go[ci];
    }

    static int search(char[] S) {
        var replaced = new boolean[S.length];
        Node node = root;
        for (int i = 0; i < S.length; ++i) {
            node = nextNode(node, S[i]);
            if (node.out > 0)
                for (int j = 0; j < node.out; ++j)
                    replaced[i - j] = true;
        }
        int count = 0;
        for (int i = 0; i < S.length; ++i)
            if (replaced[i] == false) ++count;
        return count;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        char[] S = reader.readLine().toCharArray();
        int M = Integer.parseInt(reader.readLine());
        char[][] words = new char[M][];
        for (int i = 0; i < M; ++i)
            words[i] = reader.readLine().toCharArray();
        buildMatcher(words);
        System.out.println(search(S));
    }
}