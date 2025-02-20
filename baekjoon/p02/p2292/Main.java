package baekjoon.p02.p2292;

import java.util.Scanner;

public class Main {

    static int depth(int x) {
        int sum = 1;
        if (x == 1) return 1;
        for (int n = 2; n < 1000000000; ++n) {
            sum += (n - 1) * 6;
            if (sum >= x) return n;
        }
        return -1;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int x = scanner.nextInt();
            System.out.println(depth(x));
        }
    }
}
