package baekjoon.p05.p5568;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static int N, K;
    static HashSet<Integer> set = new HashSet<>();

    static void 완전탐색(int[] A, int selectCount, boolean[] selected, String sum) {
        if (selectCount == K) {
            set.add(Integer.valueOf(sum));
            return;
        }
        for (int i = 0; i < A.length; ++i) {
            if (selected[i] == false) {
                selected[i] = true;
                완전탐색(A, selectCount + 1, selected, sum + String.valueOf(A[i]));
                selected[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; ++i)
            A[i] = scanner.nextInt();
        완전탐색(A, 0, new boolean[N], "");
        scanner.close();
        System.out.println(set.size());
    }
}