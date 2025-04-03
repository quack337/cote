package baekjoon.p05.p5905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main2 {
    static int A_SIZE = 4;
    static Node root;
    static char[][] words;
    static Integer[][] DP;

    static class Node {
        Node[] go = new Node[A_SIZE];
        Node fail;
        int out = 0, word = -1;
    }

    static void buildMatcher(char[][] words, int N) {
        root = new Node();
        for (int i = 0; i < N; ++i) {
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

    static int search(int a) {
        Node node = root;
        int out = 0;
        for (int i = 0; i < words[a].length; ++i) {
            node = nextNode(node, words[a][i]);
            out += node.out;
        }
        return out;
    }

    static int search(int a, int b) {
        Node node = root;
        int out = 0, AN = words[a].length, BN = words[b].length;
        for (int i = 0; i < AN + BN; ++i) {
            node = nextNode(node, i < AN ? words[a][i] : words[b][i - AN]);
            out += node.out;
        }
        return out;
    }

    static int sol(int length, int prevWord) {
        if (length <= 0) return 0;
        if (DP[length][prevWord+1] != null) return DP[length][prevWord+1];
        int result = 0;
        for (int i = 0; i < words.length; ++i)
            if (length >= words[i].length) {
                int value = (prevWord == -1) ? search(i) : search(prevWord, i) - search(prevWord);
                result = Math.max(result, value + sol(length - words[i].length, i));
            }
        return DP[length][prevWord+1] = result;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        words = new char[N + 3][];
        for (int i = 0; i < N; ++i)
            words[i] = reader.readLine().toCharArray();
        words[N] = new char[] {'A'}; words[N+1] = new char[] {'B'}; words[N+2] = new char[] {'C'};
        buildMatcher(words, N);
        DP = new Integer[K+1][N+4];
        System.out.println(sol(K, -1));
    }
}