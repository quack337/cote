package baekjoon.p05.p5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {

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

        public void set(int index, int value) {
            int real_index = (front + index) % a.length;
            a[real_index] = value;
        }

        public int findIndex(int value) {
            for (int i = 0; i < count(); ++i)
                if (get(i) == value) return i;
            return -1;
        }

        public void reverse() {
            int start = 0;
            int end = count() - 1;
            while (start < end) {
                int temp = get(start);
                set(start, get(end));
                set(end, temp);
                ++start; --end;
            }
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            for (int i = 0; i < count(); ++i) {
                if (i > 0) builder.append(",");
                builder.append(get(i));
            }
            return builder.append("]").toString();
        }
    }

    static void solution(Deque queue, char[] 명령) {
        boolean 뒤집힘 = false;

        for (char c : 명령) {
            if (c == 'R') 뒤집힘 = !뒤집힘;
            else if (c == 'D') {
                if (queue.isEmpty()) {
                    System.out.println("error");
                    return;
                }
                if (뒤집힘) queue.removeLast();
                else queue.removeFirst();
            }
        }
        if (뒤집힘) queue.reverse();
        System.out.println(queue);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int T = Integer.parseInt(tokenizer.nextToken());
        for (int t = 0; t < T; ++t) {
            char[] 명령 = reader.readLine().toCharArray();
            int n = Integer.parseInt(reader.readLine());
            Deque queue = new Deque(n);
            tokenizer = new StringTokenizer(reader.readLine(), " ,[]");
            for (int i = 0; i < n; ++i) {
                int value = Integer.parseInt(tokenizer.nextToken());
                queue.addLast(value);
            }
            solution(queue, 명령);
        }
    }
}