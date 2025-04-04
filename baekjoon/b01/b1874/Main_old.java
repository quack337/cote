package baekjoon.b01.b1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main_old {
    static int N;
    static int[] A;

    static String solution() {
        int number = 1;
        StringBuilder builder = new StringBuilder();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; ++i) {
            while (stack.size() == 0 || stack.peek() != A[i]) {
                if (number > N) return "NO";
                stack.push(number++);
                builder.append("+\n");
            }
            stack.pop();
            builder.append("-\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        A = new int[N];
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(reader.readLine());
        System.out.println(solution());
    }
}