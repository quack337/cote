package baekjoon.b17.p17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main1 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] A = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());
        LinkedList<Integer> stack = new LinkedList<>();
        int[] result = new int[N];
        for (int i = A.length - 1; i >= 0; --i) {
            while (stack.size() > 0) {
                if (stack.peek() > A[i])
                    break;
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(A[i]);
        }
        System.out.println(Arrays.stream(result).mapToObj(String::valueOf)
          .collect(Collectors.joining(" ")));
    }
}