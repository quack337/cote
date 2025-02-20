package baekjoon.p05.P5735;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int A_SIZE = 127 - 32, answer = 0;
    static Node root;

    static class Node {
        Node[] go = new Node[A_SIZE];
        Node fail;
        boolean out;
    }

    static void buildMatcher(char[][] words) {
        root = new Node();
        for (int i = 0; i < words.length; ++i) {
            Node node = root;
            for (char ch : words[i]) {
                int ci = ch - 32;
                if (node.go[ci] == null) node.go[ci] = new Node();
                node = node.go[ci];
            }
            node.out = true;
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
        int ci = ch - 32;
        while (node.go[ci] == null)
            node = node.fail;
        return node.go[ci];
    }

    static void search(char[] S) {
        Node node = root;
        for (int i = 0; i < S.length; ++i) {
            node = nextNode(node, S[i]);
            if (node.out) {
                node = root;
                ++answer;
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        var builder = new StringBuilder();
        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(tokenizer.nextToken());
            int M = Integer.parseInt(tokenizer.nextToken());
            if (N + M == 0) break;
            char[][] words = new char[N][];
            for (int i = 0; i < N; ++i)
                words[i] = reader.readLine().toCharArray();
            buildMatcher(words);
            answer = 0;
            for (int i = 0; i < M; ++i)
                search(reader.readLine().toCharArray());
            builder.append(answer + "\n");
        }
        System.out.println(builder.toString());
    }
}
