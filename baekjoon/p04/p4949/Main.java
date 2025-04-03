package baekjoon.p04.p4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static boolean 괄호균형확인(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[')
                stack.push(c);
            else if (c == ')') {
                if (stack.size() < 1) return false;
                if (stack.pop() != '(') return false;
            }
            else if (c == ']') {
                if (stack.size() < 1) return false;
                if (stack.pop() != '[') return false;
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = reader.readLine();
            if (s.equals(".")) break;
            System.out.println(괄호균형확인(s) ? "yes" : "no");
        }
    }
}