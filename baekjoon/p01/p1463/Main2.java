package baekjoon.p01.p1463;

import java.util.Scanner;

public class Main2 {

    static int solution(int x) {
        if (x == 1) return 0;
        int r2 = Integer.MAX_VALUE, r3  = Integer.MAX_VALUE;
        int r1 = 1 + solution(x - 1);
        if (x % 3 == 0) r3 = 1 + solution(x / 3);
        if (x % 2 == 0) r2 = 1 + solution(x / 2);
        return Math.min(r1, Math.min(r2, r3));
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int x = scanner.nextInt();
            System.out.println(solution(x));
        }
    }
}