package baekjoon.p01.p1780;

import java.util.Scanner;

public class Main {
    static int N;
    static byte[][] A;

    static boolean 같은수인가(int row, int col, int size) {
        byte value = A[row][col]; // 첫 칸의 값
        for (int r = row; r < row + size; ++r)
            for (int c = col; c < col + size; ++c)
                if (A[r][c] != value) return false; // 불일치
        return true;
    }

    static void solution(int[] count, int row, int col, int size) {
        if (같은수인가(row, col, size)) { // 영역 전체가 같은 수인가?
            count[A[row][col] + 1] += 1;  // 그렇다면, 해당 종이의 수에 1을 더하고
            return;                       // 리턴한다
        }
        int size3 = size / 3;             // 자식 영역의 크기
        for (int r = 0; r < 3; ++r)       // 9개의 자식 영역 각각에 대한 재귀호출
            for (int c = 0; c < 3; ++c)
                solution(count, row + r * size3, col + c * size3, size3);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            N = scanner.nextInt();
            A = new byte[N][N];
            for (int r = 0; r < N; ++r)
                for (int c = 0; c < N; ++c)
                    A[r][c] = scanner.nextByte();
            int[] count = new int[3];
            solution(count, 0, 0, N);
            for (int i : count)
                System.out.println(i);
        }
    }
}