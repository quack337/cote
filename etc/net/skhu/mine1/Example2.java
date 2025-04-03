package net.skhu.mine1;

import java.util.Scanner;

public class Example2 {

    public static void main(String[] args) throws Exception {

        MyStack<Double> stack = new MyStack<>();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String cmd = scanner.next();
                switch (cmd.toLowerCase()) {
                case "push": stack.push(scanner.nextDouble()); break;
                case "pop": System.out.println(stack.isEmpty() ? -1 : stack.pop()); break;
                case "top": System.out.println(stack.isEmpty() ? -1 : stack.top()); break;
                case "size": System.out.println(stack.size()); break;
                case "empty": System.out.println(stack.isEmpty() ? 1 : 0); break;
                case "add":
                    if (stack.size() < 2) System.out.println(-1);
                    else stack.push(stack.pop() + stack.pop());
                    break;
                case "subtract":
                    if (stack.size() < 2) System.out.println(-1);
                    else {
                        double value2 = stack.pop();
                        double value1 = stack.pop();
                        stack.push(value1 - value2);
                    }
                    break;
                case "multiply":
                    if (stack.size() < 2) System.out.println(-1);
                    else stack.push(stack.pop() * stack.pop());
                    break;
                case "divide":
                    if (stack.size() < 2) System.out.println(-1);
                    else if (stack.top() == 0) System.out.println(-1);
                    else {
                        double value2 = stack.pop();
                        double value1 = stack.pop();
                        stack.push(value1 / value2);
                    }
                    break;
                case "quit": return;
                }
                scanner.nextLine();
            }
        }
    }

}