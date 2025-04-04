package baekjoon.b15.p15649;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int N, M;

    static void DFS(boolean[] selected, int[] result, int index) {
        if (index == M) {
            var builder = new StringBuilder();
            for (int i : result)
                builder.append(i).append(" ");
            System.out.println(builder.toString());
            return;
        }
        for (int i = 1; i <= N; ++i)
            if (selected[i] == false) {
                selected[i] = true;
                result[index] = i;
                DFS(selected, result, index + 1);
                selected[i] = false;
            }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        DFS(new boolean[N+1], new int[M], 0);
        scanner.close();
    }
}