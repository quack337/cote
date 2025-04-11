package etcc.net.skhu.mine1;
import java.util.Scanner;

public class Example1 {

    public static void main(String[] args) throws Exception {

        MyStack<Integer> stack = new MyStack<>();
        try (Scanner scanner = new Scanner(System.in)) {
            int lineCount = scanner.nextInt();
            for (int i = 0; i < lineCount; ++i) {
                scanner.nextLine();
                String cmd = scanner.next();
                switch (cmd.toLowerCase()) {
                case "push": stack.push(scanner.nextInt()); break;
                case "pop": System.out.println(stack.isEmpty() ? -1 : stack.pop()); break;
                case "top": System.out.println(stack.isEmpty() ? -1 : stack.top()); break;
                case "size": System.out.println(stack.size()); break;
                case "empty": System.out.println(stack.isEmpty() ? 1 : 0); break;
                }
            }
        }
    }

}