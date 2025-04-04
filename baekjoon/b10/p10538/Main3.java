package baekjoon.b10.p10538;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3 {
    static int A_SIZE = 2;
    static Node root;
    static int[][] found;     // 발견한 행 번호 적기
    static int[] rowNumbers;  // 행번호 수열
    static int PH, PW, MH, MW, answer = 0;

    static class Node {
        Node[] go = new Node[A_SIZE];
        Node fail;
        int out = -1;
    }

    static void buildMatcher(char[][] words) { // 아호 코라식 알고리즘
        root = new Node();
        for (int i = 0; i < words.length; ++i) {
            Node node = root;
            for (char ch : words[i]) {
                int ci = (ch == 'o' ? 0 : 1);
                if (node.go[ci] == null) node.go[ci] = new Node();
                node = node.go[ci];
            }
            if (node.out == -1) node.out = i;
            rowNumbers[i] = node.out; // 행번호 수열
        }
        for (int ci = 0; ci < A_SIZE; ++ci)
            if (root.go[ci] == null) root.go[ci] = root;

        var queue = new ArrayDeque<Node>();
        queue.add(root);
        root.fail = root;
        while (queue.size() > 0) {
            Node node = queue.remove();
            for (int ci = 0; ci < A_SIZE; ++ci)
                if (node.go[ci] != null && node.go[ci] != root) {
                    Node nextNode = node.go[ci];
                    if (node != root) {
                        Node failNode = node.fail;
                        while (failNode.go[ci] == null)
                            failNode = failNode.fail;
                        nextNode.fail = failNode.go[ci];
                    } else
                        nextNode.fail = root;
                    queue.add(nextNode);
                }
        }
    }

    static Node nextNode(Node node, char ch) { // 아호 코라식 알고리즘
        int ci = (ch == 'o' ? 0 : 1);
        while (node.go[ci] == null)
            node = node.fail;
        return node.go[ci];
    }

    static void search(char[] S, int row) {
        Node node = root;
        for (int col = 0; col < S.length; ++col) {
            char ch = S[col];
            node = nextNode(node, ch);
            if (node.out != -1) found[row][col] = node.out; // 행 발견
        }
    }

    static int[] kmpPattern(int[] s) {
        int[] p = new int[s.length];
        int J = 0;
        for (int i = 1; i < s.length; ++i) {
            while (J > 0 && s[i] != s[J])
                J = p[J - 1];
            if (s[i] == s[J])
                p[i] = ++J;
        }
        return p;
    }

    static void kmp() {
        int[] p = kmpPattern(rowNumbers);
        for (int col = PW - 1; col < MW; ++col) {
            int J = 0;
            for (int i = 0; i < MH; ++i) {
                while (J > 0 && found[i][col] != rowNumbers[J])
                    J = p[J - 1];
                if (found[i][col] == rowNumbers[J])
                    if (++J == rowNumbers.length) {
                        ++answer; // 행번호 수열 발견
                        J = p[J - 1];
                    }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        PH = Integer.parseInt(tokenizer.nextToken());
        PW = Integer.parseInt(tokenizer.nextToken());
        MH = Integer.parseInt(tokenizer.nextToken());
        MW = Integer.parseInt(tokenizer.nextToken());
        found = new int[MH][MW];
        for (int[] a : found) Arrays.fill(a, -1);
        rowNumbers = new int[PH];
        char[][] P = new char[PH][];
        for (int i = 0; i < PH; ++i)
            P[i] = reader.readLine().toCharArray();
        buildMatcher(P);
        for (int i = 0; i < MH; ++i) {
            char[] S = reader.readLine().toCharArray();
            search(S, i);
        }
        kmp();
        System.out.println(answer);
    }
}