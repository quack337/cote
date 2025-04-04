package baekjoon.b02.p2609;

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

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(최대공약수(a, b));
            int 최소공배수 = a * b / 최대공약수(a, b);
            System.out.println(최소공배수);
        }
    }
}