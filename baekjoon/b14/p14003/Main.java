package baekjoon.b14.p14003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MIN_VALUE = -1000000001;

    static class Node implements Comparable<Node> {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public int compareTo(Node n) {
            return value - n.value;
        }

        public void print(StringBuilder builder) {
            if (next != null && next.value > MIN_VALUE) next.print(builder);
            builder.append(value).append(' ');
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] A = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());

        Node[] 길이 = new Node[N+1];
        길이[0] = new Node(MIN_VALUE, null);
        int count = 1;
        Node key = new Node(0, null);
        for (int i = 0; i < N; ++i) {
            key.value = A[i];
            int index = Arrays.binarySearch(길이, 0, count, key);
            if (index < 0) index = -index - 1;
            if (index == count) ++count;
            길이[index] = new Node(A[i], 길이[index-1]);
        }
        StringBuilder builder = new StringBuilder();
        builder.append(count - 1).append('\n');
        길이[count - 1].print(builder);
        System.out.println(builder.toString());
    }
}