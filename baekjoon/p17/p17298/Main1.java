package baekjoon.p17.p17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main1 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] A = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();
        for (int i = A.length - 1; i >= 0; --i) {
            while (stack.size() > 0) {
                if (stack.peek() > A[i])
                    break;
                stack.pop();
            }
            builder.insert(0, " ").insert(0, stack.isEmpty() ? -1 : stack.peek());
            stack.push(A[i]);
        }
        System.out.println(builder.toString());
    }
}
