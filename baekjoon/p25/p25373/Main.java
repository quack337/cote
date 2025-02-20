package baekjoon.p25.p25373;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            long N = scanner.nextLong();
            long answer = -1;
            if (N > 21) {
                answer = (N + 21) / 7;
                if ((N + 21) % 7 != 0)
                    answer += 1;
            }
            else if (N > 15) answer = 6;
            else if (N > 10) answer = 5;
            else if (N > 6) answer = 4;
            else if (N > 3) answer = 3;
            else if (N > 1) answer = 2;
            else answer = 1;
            System.out.println(answer);
        }
    }
}
