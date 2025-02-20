package baekjoon.p10.p10866;

import java.util.Scanner;

public class Main {

    static class Deque {
        int[] a;
        int front = 0, back = 0, count = 0;

        public Deque(int size) {
            this.a = new int[size];
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public int count() {
            return count;
        }

        public int front() {
            if (count == 0) return -1;
            return a[front];
        }

        public int back() {
            if (count == 0) return -1;
            return a[(back - 1 + a.length) % a.length];
        }

        public void pushBack(int value) {
            if (count == a.length) expand();
            a[back] = value;
            back = (back + 1) % a.length;
            ++count;
        }

        public void pushFront(int value) {
            if (count == a.length) expand();
            front = (front + a.length - 1) % a.length;
            a[front] = value;
            ++count;
        }

        public int popFront() {
            if (count == 0) return -1;
            int value = a[front];
            front = (front + 1) % a.length;
            --count;
            return value;
        }

        public int popBack() {
            if (count == 0) return -1;
            back = (back + a.length - 1) % a.length;
            --count;
            return a[back];
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
            back = count;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Deque queue = new Deque(10);
            int N = scanner.nextInt();
            for (int i = 0; i < N; ++i) {
                String cmd = scanner.next();
                switch (cmd.toLowerCase()) {
                case "push_front":
                    queue.pushFront(scanner.nextInt());
                    break;
                case "push_back":
                    queue.pushBack(scanner.nextInt());
                    break;
                case "pop_front":
                    System.out.println(queue.popFront());
                    break;
                case "pop_back":
                    System.out.println(queue.popBack());
                    break;
                case "size":
                    System.out.println(queue.count());
                    break;
                case "empty":
                    System.out.println(queue.count() == 0 ? 1: 0);
                    break;
                case "front":
                    System.out.println(queue.front());
                    break;
                case "back":
                    System.out.println(queue.back());
                    break;
                }
            }
        }
    }
}
