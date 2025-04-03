package baekjoon.p09.p9184;

import java.util.Scanner;

public class Main1 {

    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0)
            return 1;
        if (a > 20 || b > 20 || c > 20)
            return w(20, 20, 20);
        if (a < b && b < c)
            return w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        return w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (a == -1 && b == -1 && c == -1) break;
            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
        }
        scanner.close();
    }

}