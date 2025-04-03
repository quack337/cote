package baekjoon.p01.p1021.copy;

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

        public void addLast(int value) {
            if (count == a.length) expand();
            a[back] = value;
            back = (back + 1) % a.length;
            ++count;
        }

        public void addFirst(int value) {
            if (count == a.length) expand();
            front = (front + a.length - 1) % a.length;
            a[front] = value;
            ++count;
        }

        public int removeFirst() {
            if (count == 0) return -1;
            int value = a[front];
            front = (front + 1) % a.length;
            --count;
            return value;
        }

        public int removeLast() {
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

        public int get(int index) {
            int real_index = (front + index) % a.length;
            return a[real_index];
        }

        public int findIndex(int value) {
            for (int i = 0; i < count(); ++i)
                if (get(i) == value) return i;
            return -1;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            for (int i = 0; i < count(); ++i)
                builder.append(get(i)).append(", ");
            return builder.append("]").toString();
        }

    }

    static final int 왼쪽 = 0, 오른쪽 = 1;

    static class RotatingQueue extends Deque {

        public RotatingQueue(int size) {
            super(size);
        }

        public void 회전(int 방향) {
            if (방향 == 왼쪽) {
                int value = super.removeFirst();
                super.addLast(value);
            } else {
                int value = super.removeLast();
                super.addFirst(value);
            }
        }

        public int 꺼내기() {
            return super.removeFirst();
        }

        public int 가까운쪽(int value) {
            int index = findIndex(value);
            return (index <= super.count() / 2) ? 왼쪽 : 오른쪽;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            RotatingQueue queue = new RotatingQueue(N);
            for (int i = 0; i < N; ++i)
                queue.addLast(i + 1);
            int 회전수 = 0;
            for (int i = 0; i < M; ++i) {
                int value = scanner.nextInt();
                int 방향 = queue.가까운쪽(value);
                while (queue.front() != value) {
                    queue.회전(방향);
                    ++회전수;
                }
                queue.꺼내기();
            }
            System.out.println(회전수);
        }
    }
}