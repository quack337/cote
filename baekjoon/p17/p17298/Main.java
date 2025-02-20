package baekjoon.p17.p17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] A = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());
        LinkedList<Integer> stack = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = A.length - 1; i >= 0; --i) {
            while (stack.size() > 0) {
                if (stack.peek() > A[i])
                    break;
                stack.pop();
            }
            result.add(stack.isEmpty() ? -1 : stack.peek());
            stack.push(A[i]);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = result.size() - 1; i >= 0; --i)
            builder.append(result.get(i)).append(" ");
        System.out.println(builder.toString());
    }
}
