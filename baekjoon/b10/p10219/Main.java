package baekjoon.b10.p10219;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    @SuppressWarnings("unused")
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int T = scanner.nextInt();
            for (int t = 0; t < T; ++t) {
                int H = scanner.nextInt();
                int W = scanner.nextInt();
                for (int y = 0; y < H; ++y) {
                    String s = scanner.next();
                    for (int x = s.length() - 1; x >= 0; --x)
                        System.out.print(s.charAt(x));
                    System.out.println();
                }
            }
        }
    }
}