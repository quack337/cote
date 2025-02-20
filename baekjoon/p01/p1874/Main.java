package baekjoon.p01.p1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static int N;
    static int[] A;

    static String solution() {
        int number = 1;
        StringBuilder builder = new StringBuilder();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; ++i) { // 다음에 출력할 숫자는 A[i] 이다.
            while (A[i] >= number) {
                stack.push(number++);
                builder.append("+\n");
            }
            // 이제 A[i] > number 이다.
            if (A[i] != stack.peek()) return "NO";
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
