package baekjoon.b10256;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int A_SIZE = 4;
    static Node root;
    static char[] charMap = new char[] {0,0,1,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0};

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
                int ci = charMap[ch - 'A'];
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
        int ci = charMap[ch - 'A'];
        while (node.go[ci] == null)
            node = node.fail;
        return node.go[ci];
    }

    static int search(char[] S) {
        int count = 0;
        Node node = root;
        for (char ch : S) {
            node = nextNode(node, ch);
            if (node.out) ++count;
        }
        return count;
    }

    static char[][] mutate(char[] marker, int M) {
        var list = new ArrayList<char[]>();
        list.add(marker);
        for (int from = 0; from < M-1; ++from)
            for (int to = from + 1; to < M; ++to) {
                char[] mutant = Arrays.copyOf(marker, M);
                int f = from, t = to;
                while (f < t) {
                    char ch = mutant[f];
                    mutant[f] = mutant[t];
                    mutant[t] = ch;
                    ++f; --t;
                }
                list.add(mutant);
            }
        return list.toArray(new char[list.size()][]);
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        var builder = new StringBuilder();
        for (int t = 0; t < T; ++t) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(tokenizer.nextToken());
            int M = Integer.parseInt(tokenizer.nextToken());
            char[] DNA = reader.readLine().toCharArray();
            char[] marker = reader.readLine().toCharArray();
            buildMatcher(mutate(marker, M));
            builder.append(search(DNA) + "\n");
        }
        System.out.println(builder.toString());
    }
}