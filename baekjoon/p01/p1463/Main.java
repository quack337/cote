package baekjoon.p01.p1463;

import java.util.Scanner;

public class Main {

    static int solution2(int X) {
        int[] a = new int[Math.max(4, X + 1)]; // 배열의 최소크기 4, 배열의 마지막 인덱스 X
        a[1] = 0;
        a[2] = 1;
        a[3] = 1;
        for (int x = 4; x <= X; ++x) {
            a[x] = a[x-1] + 1; // x에서 1을 빼는 것부터 시작했을 때, 연산 횟수
            if (x % 2 == 0) a[x] = Math.min(a[x], a[x/2] + 1); // x에서 2를 나누는 것부터 시작했을 때, 연산수
            if (x % 3 == 0) a[x] = Math.min(a[x], a[x/3] + 1); // x에서 3을 나누는 것부터 시작했을 때, 연산수
        }
        return a[X];
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int x = scanner.nextInt();
            System.out.println(solution2(x));
        }
    }
}