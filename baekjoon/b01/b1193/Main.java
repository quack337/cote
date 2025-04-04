package baekjoon.b01.b1193;

import java.util.Scanner;

public class Main {

    static int sum(int n) {
        return n * (n + 1) / 2;
    }

    static int depth(int x) {
        return (int)Math.round(Math.sqrt(2 * x));
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int x = scanner.nextInt();
            int depth = depth(x);
            int 열 = x - sum(depth - 1);
            int 행 = depth - 열 + 1;
            System.out.printf("%d/%d\n", (depth % 2 == 1) ? 행 : 열, (depth % 2 == 1) ? 열 : 행);
        }
    }
}