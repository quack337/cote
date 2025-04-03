package baekjoon.p02.p2231;

import java.io.IOException;

public class Example1 {
    static int 분해합(int n) {
        int sum = n; // 먼저 자기 자신을 더하고
        while (n > 0) {
            sum += n % 10; // 각 자리수를 더한다.
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        System.out.println(분해합(245));
    }
}