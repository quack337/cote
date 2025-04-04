package baekjoon.b14.p14490;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int 최대공약수(int a, int b){
        while (a != 0) {
            if (b > a) {
                int t = a;
                a = b;
                b = t;
            }
            a = a % b;
        }
        return b;
    }

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            scanner.useDelimiter("[:\r\n]");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int gcd = 최대공약수(a, b);
            System.out.printf("%d:%d\n", a/gcd, b/gcd);
        }
    }
}