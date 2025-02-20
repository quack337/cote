package baekjoon.p10.p10845;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class CircularQueue {
        int[] a;
        int front = 0, end = 0, count = 0;

        public CircularQueue(int size) {
            this.a = new int[size];
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public int size() {
            return count;
        }

        public void push(int value) {
            if (count == a.length) expand();
            a[end] = value;
            end = (end + 1) % a.length;
            ++count;
        }

        public int pop() throws Exception {
            if (isEmpty()) throw new Exception("empty");
            int value = a[front];
            front = (front + 1) % a.length;
            --count;
            return value;
        }

        public void expand() {
            int size = a.length * 2;
            int[] b = new int[size];
            for (int i = 0; i < count; ++i) {
                int index = (front + i) % a.length;
                b[i] = a[index];
            }
            a = b;
            front = 0;
            end = count;
        }

        public int getFront() {
            return a[front];
        }

        public int getBack() {
            return a[end == 0 ? a.length - 1 : end - 1];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CircularQueue queue = new CircularQueue(10);
        int N = Integer.parseInt(reader.readLine());
        for (int i = 0; i < N; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String cmd = tokenizer.nextToken();
            switch (cmd) {
            case "push": queue.push(Integer.parseInt(tokenizer.nextToken())); break;
            case "pop": System.out.println(queue.size() > 0 ? queue.pop() : -1); break;
            case "size": System.out.println(queue.size()); break;
            case "empty": System.out.println(queue.isEmpty() ? 1 : 0); break;
            case "front": System.out.println(queue.size() > 0 ? queue.getFront() : -1); break;
            case "back": System.out.println(queue.size() > 0 ? queue.getBack() : -1); break;
            }
        }
    }
}
