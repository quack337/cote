package baekjoon.p10.p10773;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; ++i) {
            int a = scanner.nextInt();
            if (a == 0) stack.pop();
            else stack.push(a);
        }
        int sum = 0;
        for (int a : stack)
            sum += a;
        System.out.println(sum);
        scanner.close();
    }
}
