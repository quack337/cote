package net.skhu.mine1;

import java.util.Scanner;

public class Example3 {

    public static void main(String[] args) throws Exception {

        MyStack<Double> stack = new MyStack<>();
        try (Scanner scanner = new Scanner(System.in)) {
            for (String token : scanner.nextLine().split("[ \t]+")) {
                switch (token) {
                case "+":
                    if (stack.size() < 2) return;
                    else stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    if (stack.size() < 2) return;
                    else {
                        double value2 = stack.pop();
                        double value1 = stack.pop();
                        stack.push(value1 - value2);
                    }
                    break;
                case "*":
                    if (stack.size() < 2) return;
                    else stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    if (stack.size() < 2) return;
                    else if (stack.top() == 0) return;
                    else {
                        double value2 = stack.pop();
                        double value1 = stack.pop();
                        stack.push(value1 / value2);
                    }
                    break;
                default:
                    stack.push(Double.valueOf(token));
                    break;
                }
            }
            System.out.println(stack.pop());
        }
    }

}
