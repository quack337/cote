package baekjoon.b02.p2992;

import java.util.Scanner;

public class Main3 {

    // result를 int 타입으로 구현
    static void 완전탐색(int[] digits, boolean[] selected, int selectCount, int result) {
        if (selectCount == selected.length) {
            System.out.println(result);
            return;
        }
        for (int i = 0; i < selected.length; ++i) {
            if (selected[i] == false) {
                selected[i] = true;
                완전탐색(digits, selected, selectCount + 1, result * 10 + digits[i]);
                selected[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        String s = String.valueOf(X);
        int N = s.length();
        int[] digits = new int[N];
        for (int i = 0; i < N; ++i)
            digits[i] = s.charAt(i) - '0';
        완전탐색(digits, new boolean[N], 0, 0);
        scanner.close();
    }

}