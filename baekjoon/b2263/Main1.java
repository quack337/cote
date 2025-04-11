package baekjoon.b2263;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main1 {
    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }

        public void print() {
            if (left != null) left.print();
            System.out.printf("%d ", value);
            if (right != null) right.print();
        }

        @Override
        public String toString() {
            return "(" + left + " " + value + " " + right + ")";
        }
    }

    static ArrayDeque<Integer> preorderNumbers = new ArrayDeque<>();
    static HashMap<Integer,Integer> inorderIndex = new HashMap<>();

    static Node parsePreOrder(int lowerIndex, int upperIndex) {
        System.out.printf("%d %d\n", lowerIndex, upperIndex);
        if (preorderNumbers.size() == 0) return null;
        int value = preorderNumbers.getFirst();
        int index = inorderIndex.get(value);
        if (index < lowerIndex || value > upperIndex) return null;
        preorderNumbers.removeFirst();
        Node node = new Node(value);
        node.left = parsePreOrder(lowerIndex, index);
        node.right = parsePreOrder(index, upperIndex);
        System.out.println(node);
        return node;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        while (tokenizer.hasMoreElements())
            preorderNumbers.addLast(Integer.parseInt(tokenizer.nextToken()));
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i) {
            int value = Integer.parseInt(tokenizer.nextToken());
            inorderIndex.put(value, i);
        }
        Node node = parsePreOrder(-1, N);
        node.print();
    }
}