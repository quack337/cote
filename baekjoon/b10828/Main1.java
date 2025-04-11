package baekjoon.b10828;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main1 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> stack = new ArrayDeque<>();
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