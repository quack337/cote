package baekjoon.b02.p2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example2 {
    static int 분해합(int n) {
        int sum = n; // 먼저 자기 자신을 더하고
        while (n > 0) {
            sum += n % 10; // 각 자리수를 더한다.
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        // N의 분해합 무식하게 찾기
        for (int i = 1; i < N; ++i)
            if (분해합(i) == N) {
                System.out.println(i);
                break;
            }
    }
}