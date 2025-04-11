package baekjoon.b1094;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static int sum(ArrayDeque<Integer> stack) {
        int result = 0;
        for (int i : stack)
            result += i;
        return result;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(reader.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(64);
        while (sum(stack) != X) {
            int min = stack.pop() / 2;
            stack.push(min);
            if (sum(stack) < X) stack.push(min);
        }
        System.out.println(stack.size());
    }
}