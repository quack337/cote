package net.skhu.brother;

import java.util.Arrays;

public class Exam07a {

    static class MyStack {
        char[] a = new char[10];
        int count = 0;

        public void push(char c) {
            if (count >= a.length) expand();
            a[count++] = c;
        }

        void expand() {
            a = Arrays.copyOf(a, a.length * 2);
        }

        public char peek() {
            return a[count - 1];
        }

        public char pop() {
            return a[--count];
        }

        public int count() {
            return count;
        }

        @Override
        public String toString() {
            return new String(a, 0, count);
        }
    }

    public static String solution(String s) {
        MyStack stack = new MyStack();
        for (char c : s.toCharArray())
            if (stack.count() > 0 && stack.peek() == c)
                stack.pop();
            else
                stack.push(c);
        return stack.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("browoanoommnaon"));
    }

}