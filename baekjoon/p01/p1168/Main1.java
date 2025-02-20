package baekjoon.p01.p1168;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

public class Main1 {

    static class Node {
        int value;
        Node prev, next;

        public Node addAfter(int value) {
            Node node = new Node();
            node.value = value;
            node.next = this.next;
            node.prev = this;
            this.next.prev = node;
            this.next = node;
            return node;
        }

        public Node remove() {
            this.prev.next = this.next;
            this.next.prev = this.prev;
            return this;
        }
    }

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            Node head = new Node();
            head.value = 1;
            head.next = head.prev = head;
            Node node = head;
            for (int i = 2; i <= N; ++i)
                node = node.addAfter(i);

            Writer writer = new BufferedWriter(new OutputStreamWriter(System.out));
            writer.write("<");
            boolean first = true;
            while (N > 0) {
                for (int i = 0; i < K; ++i)
                    node = node.next;
                if (!first) writer.write(", ");
                else first = false;
                writer.write(String.valueOf(node.value));
                node = node.remove();
                --N;
            }
            writer.write(">");
            writer.close();
        }
    }

}
