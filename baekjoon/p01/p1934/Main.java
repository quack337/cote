package baekjoon.p01.p1934;

import java.util.Scanner;

public class Main {

    // 유클리드 최대공약수 알고리즘
    static long 최대공약수(long a, long b){
        while (a != 0) {
            if (b > a) {
                long t = a;
                a = b;
                b = t;
            }
            a = a % b;
        }
        return b;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long 최소공배수 = a * b / 최대공약수(a, b);
            System.out.println(최소공배수);
        }
    }
}
