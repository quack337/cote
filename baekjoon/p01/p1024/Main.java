package baekjoon.p01.p1024;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int 합계 = scanner.nextInt();
            int 길이 = scanner.nextInt();
            
            for ( ; 길이 <= 100; ++길이) {
                double a = (2.0 * 합계 / 길이 - 길이 + 1) / 2.0;
                if (a >= 0 && a == (int)a) {
                    for (int i = 0; i < 길이; ++i)
                        System.out.printf("%d ", (int)a + i);
                    System.out.println();
                    return;
                }
            }
            System.out.println(-1);
        }        
    }
}