package baekjoon.p17.p17300;

import java.util.Scanner;

public class Main {

static int[][] 직선목록 = {
        {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, // 가로 직선
        {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, // 세로 직선
        {1, 5, 9}, {3, 5, 7} // 대각선
};

static boolean isValid(int[] A) {
    if (A.length < 3) return false;
    var visited = new boolean[10];
    int prev_no = A[0];
    for (int no : A) {
        if (visited[no]) return false; // 중복 발견
        visited[no] = true;

        // 가운데 빠진 것이 있나
        for (int[] 직선 : 직선목록)
            if (visited[직선[1]] == false) {
                if (직선[0] == no && 직선[2] == prev_no) return false;
                if (직선[2] == no && 직선[0] == prev_no) return false;
            }
        prev_no = no;
    }
    return true;
}

    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            int L = scanner.nextInt();
            int[] A = new int[L];
            for (int i = 0; i < L; ++i)
                A[i] = scanner.nextInt();
            System.out.println(isValid(A) ? "YES" : "NO");
        }
    }
}
