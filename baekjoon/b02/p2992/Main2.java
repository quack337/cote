package baekjoon.b02.p2992;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    static void 완전탐색(int[] digits, boolean[] selected, int selectCount, int[] result) {
        if (selectCount == selected.length) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = 0; i < selected.length; ++i) {
            if (selected[i] == false) {
                selected[i] = true;
                result[selectCount] = digits[i];
                완전탐색(digits, selected, selectCount + 1, result);
                selected[i] = false;
            }
        }
    }

    // 입력된 X에서 digit 배열 만들기
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        String s = String.valueOf(X);
        int N = s.length();
        int[] digits = new int[N];
        for (int i = 0; i < N; ++i)
            digits[i] = s.charAt(i) - '0';
        완전탐색(digits, new boolean[N], 0, new int[N]);
        scanner.close();
    }

}