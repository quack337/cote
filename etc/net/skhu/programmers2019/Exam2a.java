package net.skhu.programmers2019;

import java.util.Stack;

public class Exam2a {

    static void print(Stack<Character> 경로) {
        for (char c : 경로)
            System.out.print(c);
        System.out.println();
    }

    static void 탐색(int 여는괄호수, int 닫는괄호수, Stack<Character> 경로) {
        if (여는괄호수 == 0 && 닫는괄호수 == 0) {
            print(경로);
            return;
        }
        if (여는괄호수 > 0) {
            경로.push('(');
            탐색(여는괄호수 - 1, 닫는괄호수, 경로);
            경로.pop();
        }
        if (닫는괄호수 > 0) {
            경로.push(')');
            탐색(여는괄호수, 닫는괄호수 - 1, 경로);
            경로.pop();
        }
    }

    public static void main(String[] args) {
        탐색(3, 3, new Stack<>());
    }
}