package baekjoon.p02.p2504;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main1 {
    // 괄호 검사
    static boolean VPS(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            switch (c) {
            case '(':
            case '[':
                stack.push(c);
                break;
            case ')':
                if (stack.size() == 0 || stack.pop() != '(') return false;
                break;
            case ']':
                if (stack.size() == 0 || stack.pop() != '[') return false;
                break;
            }
        }
        return stack.isEmpty();
    }

    static String s;
    static int index = 0;

    // 값 계산
    static int 괄호한개읽기() throws Exception {
        if (index >= s.length()) return 0;
        char c1 = s.charAt(index);
        ++index;
        int result = 괄호열읽기();
        if (index >= s.length()) throw new Exception();
        char c2 = s.charAt(index++);
        if (c1 == '(' && c2 == ')') return result == 0 ? 2 : result * 2;
        if (c1 == '[' && c2 == ']') return result == 0 ? 3 : result * 3;
        throw new Exception();
    }

    static int 괄호열읽기() throws Exception {
        int result = 0;
        while (true) {
            if (index >= s.length()) break;
            char c = s.charAt(index);
            if (c != '(' && c != '[') break;
            result += 괄호한개읽기();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        s = reader.readLine();
        System.out.println(VPS(s) ? 괄호열읽기() : 0);
    }
}
