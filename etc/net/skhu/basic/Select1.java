package net.skhu.basic;

public class Select1 {

    static final int[] numbers = {1, 2, 3, 4, 5};

    // numbers 배열에서 숫자 3개 선택 모든 조합
    // 선택 순서는 중요하지 않다.
    static void solution(boolean[] selected, int selectCount, int index) {
        if (selectCount == 3) {
            for (int i = 0; i < selected.length; ++i)
                if (selected[i]) System.out.printf("%d ", numbers[i]);
            System.out.println();
            return;
        }
        if (index >= selected.length) return;

        // index 위치의 수를 선택하지 않고 재귀호출
        solution(selected, selectCount, index + 1);

        // index 위치의 수를 선택하고 재귀호출
        selected[index] = true;
        solution(selected, selectCount + 1, index + 1);
        selected[index] = false;
    }

    public static void main(String[] args) {
        int N = numbers.length;
        solution(new boolean[N], 0, 0);
    }

}