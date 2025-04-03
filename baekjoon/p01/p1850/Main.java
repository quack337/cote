package baekjoon.p01.p1850;

import java.util.Scanner;

public class Main {
    static long 최대공약수(long a, long b){
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long g = 최대공약수(a, b);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < g; ++i)
                builder.append('1');
            System.out.println(builder.toString());
        }
    }
}