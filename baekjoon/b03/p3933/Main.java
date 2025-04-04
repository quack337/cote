package baekjoon.b03.p3933;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int N = scanner.nextInt();
            if (N == 0) break;
            int M = (int)Math.sqrt(N);
            int count = 0;
            if (M * M == N) { ++count; --M; }
            for (int a = 1; a <= M; ++a) {
                int a2 = a * a;
                for (int b = a; b <= M; ++b) {
                    int b2 = b * b;
                    if (a2 + b2 == N) { ++count; break; }
                    if (a2 + b2 > N) break;
                    for (int c = b; c <= M; ++c) {
                        int c2 = c * c;
                        if (a2 + b2 + c2 == N) { ++count; break; }
                        if (a2 + b2 + c2 > N) break;
                        for (int d = c; d <= M; ++d) {
                            int d2 = d * d;
                            if (a2 + b2 + c2 + d2 == N) { ++count; break; }
                            if (a2 + b2 + c2 + d2 > N) break;
                        }
                    }
                }
            }
            System.out.println(count);
        }
        scanner.close();
    }
}