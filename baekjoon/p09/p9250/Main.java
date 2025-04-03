package baekjoon.p09.p9250;

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
        boolean out = false;
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
            node.out = true; // 단어 완성
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
                    if (nextNode.fail.out) nextNode.out = true;
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

    static boolean search(char[] S) {
        Node node = root;
        for (char ch : S) {
            node = nextNode(node, ch);
            if (node.out) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        var words = new char[N][];
        for (int i = 0; i < N; ++i)
            words[i] = reader.readLine().toCharArray();
        buildMatcher(words);
        int Q = Integer.parseInt(reader.readLine());
        var builder = new StringBuilder();
        for (int i = 0; i < Q; ++i) {
            char[] S = reader.readLine().toCharArray();
            builder.append(search(S) ? "YES\n" : "NO\n");
        }
        System.out.println(builder.toString());
    }
}