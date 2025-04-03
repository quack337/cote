package baekjoon.p10.p10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Stack {
        int count = 0;
        int[] a = new int[10];

        private void expand() {
            a = Arrays.copyOf(a, a.length * 2); // a 배열을 두 배 확장한다.
        }

        public void push(int value) {
            if (count == a.length) expand(); // a 배열이 꽉 찾으면 확장
            a[count++] = value;
        }

        public int pop() {
            return a[--count];
        }

        public int size() {
            return count;
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public int peek() {
            return a[count - 1];
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack stack = new Stack();
        int N = Integer.parseInt(reader.readLine());
        for (int i = 0; i < N; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String cmd = tokenizer.nextToken();
            switch (cmd) {
            case "push": stack.push(Integer.parseInt(tokenizer.nextToken())); break;
            case "pop": System.out.println(stack.size() > 0 ? stack.pop() : -1); break;
            case "size": System.out.println(stack.size()); break;
            case "empty": System.out.println(stack.isEmpty() ? 1 : 0); break;
            case "top": System.out.println(stack.size() > 0 ? stack.peek() : -1); break;
            }
        }
    }
}