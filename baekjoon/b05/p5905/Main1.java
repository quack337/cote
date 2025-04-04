package baekjoon.b05.p5905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main1 {
    static int A_SIZE = 3;
    static Node root;
    static int[] values; // 각 단어에 포함된 부분 단어의 수
    static char[][] words;
    static Integer[] DP = new Integer[1001];

    static class Node {
        Node[] go = new Node[A_SIZE];
        Node fail;
        int out = 0, word = -1;
    }

    static void buildMatcher(char[][] words) {
        root = new Node();
        for (int i = 0; i < words.length; ++i) {
            Node node = root;
            for (char ch : words[i]) {
                int ci = ch - 'A';
                if (node.go[ci] == null) node.go[ci] = new Node();
                node = node.go[ci];
            }
            node.out = 1; node.word = i;
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
                    nextNode.out += nextNode.fail.out;
                    queue.add(nextNode);
                }
        }
    }

    static Node nextNode(Node node, char ch) {
        int ci = ch - 'A';
        while (node.go[ci] == null)
            node = node.fail;
        return node.go[ci];
    }

    static void DFS(Node node, int out, String s) {
        if (node.word >= 0) values[node.word] = out + node.out;
        for (int ci = 0; ci < A_SIZE; ++ci)
            if (node.go[ci] != null && node.go[ci] != root)
                DFS(node.go[ci], out + node.out, s + (char)('A' + ci));
    }

    static int sol(int length) {
        if (length <= 0) return 0;
        if (DP[length] != null) return DP[length];
        int result = 0;
        for (int i = 0; i < words.length; ++i)
            if (length >= words[i].length)
                result = Math.max(result, values[i] + sol(length - words[i].length));
        return DP[length] = result;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        words = new char[N][];
        for (int i = 0; i < N; ++i)
            words[i] = reader.readLine().toCharArray();
        values = new int[N];
        buildMatcher(words);
        DFS(root, 0, "");
        System.out.println(sol(K));
    }
}