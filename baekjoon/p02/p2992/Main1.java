package baekjoon.p02.p2992;

import java.util.Arrays;

public class Main1 {

    // 답 아님. digits 선택 모든 조합 완전탐색 구현. 선택 순서 중요.
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

    public static void main(String[] args) {
        완전탐색(new int[] {1,2,3}, new boolean[3], 0, new int[3]);
    }

}
