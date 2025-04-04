package baekjoon.b02.p2263;

import java.util.Scanner;

public class Main {
    static int[] 포스트오더, 인오더순서;

    static void 프리오더출력(int start, int end) {
        if (start > end) return;          // 종료 조건
        int 루트값 = 포스트오더[end];
        System.out.printf("%d ", 루트값); // 루트 항목 출력
        if (start == end) return;         // 종료 조건

        // 왼쪽 서브트리와 오른쪽 서브트리 경계 찾기
        int i = start;
        while (i < end) {
            int 값 = 포스트오더[i];
            if (인오더순서[값] > 인오더순서[루트값]) break;
            ++i;
        }

        프리오더출력(start, i - 1); // 왼쪽 서브트리 출력
        프리오더출력(i, end - 1);   // 오른쪽 서브트리 출력
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            인오더순서 = new int[N + 1];
            for (int i = 0; i < N; ++i) {
                int 값 = scanner.nextInt();
                인오더순서[값] = i;
            }
            포스트오더 = new int[N];
            for (int i = 0; i < N; ++i)
                포스트오더[i] = scanner.nextInt();
            프리오더출력(0, N - 1);
        }
    }
}