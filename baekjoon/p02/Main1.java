package baekjoon.p02;

public class Main1 {

    static void solution(int[] digits, boolean[] selected, int selectCount, int value) {
        if (selectCount == digits.length) {
            System.out.println(value);
            return;
        }
        for (int i = 0; i < selected.length; ++i) {
            if (selected[i] == false) {
                selected[i] = true;
                solution(digits, selected, selectCount + 1, value * 10 + digits[i]);
                selected[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        solution(new int[] {1, 2, 3, 4}, new boolean[4], 0, 0);
    }
}