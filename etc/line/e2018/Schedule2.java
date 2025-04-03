package line.e2018;

import java.util.Stack;

public class Schedule2 {

    static void schedule(Stack<Integer> selected, int value) {
        if (value < 0) {
            System.out.println(selected);
            return;
        }
        selected.push(value); // 선택 목록에 value를 추가하고
        schedule(selected, value - 1); // 재귀호출
        selected.pop();       // 선택 목록에서 value를 제거하고
        schedule(selected, value - 1); // 재귀호출
    }

    public static void main(String[] args) {
        // 0, 1, 2 세 숫자 중에서 몇 개를 선택할 때,
        // 모든 가능한 조합 출력하기 재귀호출
        schedule(new Stack<Integer>(), 2);
    }
}
