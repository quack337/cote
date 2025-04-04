package baekjoon.b17.p17136;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int findOne(int[][] A) {
        for (int r = 0; r < 10; ++r)
            for (int c = 0; c < 10; ++c)
                if (A[r][c] == 1) return r * 10 + c;
        return -1;
    }

    static int getSize(int[][] A, int r, int c) {
        int depth = 1;
        for (; depth < 5 && r + depth < 10 && c + depth < 10; ++depth)
            for (int i = 0; i <= depth; ++i)
                if (A[r + depth][c + i] != 1 || A[r + i][c + depth] != 1)
                    return depth;
        return depth;
    }

    static int solution(int[][] A, int[] paper, int count) {
        int index = findOne(A);
        if (index == -1) return count;
        int answer = Integer.MAX_VALUE;
        int r = index / 10, c = index % 10;
        int size = getSize(A, r, c);
        for (int size1 = 1; size1 <= size; ++size1)
            if (paper[size1-1] > 0) {
                int[] paper1 = paper.clone();
                int[][] A1 = Arrays.stream(A).map(int[]::clone).toArray(int[][]::new);
                paper1[size1-1]--;
                for (int rr = 0; rr < size1; ++rr)
                for (int cc = 0; cc < size1; ++cc)
                    A1[r + rr][c + cc] = 0;
                int temp = solution(A1, paper1, count + 1);
                if (temp < answer) answer = temp;
            }
        return answer;
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int[][] A = new int[10][10];
        for (int r = 0; r < 10; ++r)
            for (int c = 0; c < 10; ++c)
                A[r][c] = scanner.nextInt();
        int answer = solution(A, new int[] {5,5,5,5,5}, 0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}