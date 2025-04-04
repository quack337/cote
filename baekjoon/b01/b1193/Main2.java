package baekjoon.b01.b1193;

import java.util.Scanner;

public class Main2 {

    static String solution(int x) {
        int count = 0;
        for (int row = 1; row < 100000000; ++row)
            for (int col = 1; col <= row; ++col) {
                int n1 = col, n2 = row - col + 1;
                if (++count == x)
                    return String.format("%d/%d", (row % 2 == 0) ? n1 : n2, (row % 2 == 0) ? n2 : n1);
            }
        return null;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            System.out.println(solution(n));
        }
    }
}