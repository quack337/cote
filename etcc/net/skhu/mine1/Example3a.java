package etcc.net.skhu.mine1;
import java.util.Scanner;

public class Example3a {

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
                    else stack.push(0 - stack.pop() + stack.pop());
                    break;
                case "*":
                    if (stack.size() < 2) return;
                    else stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    if (stack.size() < 2) return;
                    else if (stack.top() == 0) return;
                    else stack.push(1 / stack.pop() * stack.pop());
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