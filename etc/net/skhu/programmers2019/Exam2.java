package net.skhu.programmers2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Exam2 {

    static void 경로추가(List<String> 결과, Stack<Character> 경로) {
        StringBuilder builder = new StringBuilder();
        for (char c : 경로)
            builder.append(c);
        결과.add(builder.toString());
    }

    static void 탐색(int 여는괄호수, int 닫는괄호수, Stack<Character> 경로, List<String> 결과) {
        if (여는괄호수 == 0 && 닫는괄호수 == 0) {
            경로추가(결과, 경로);
            return;
        }
        if (여는괄호수 > 0) {
            경로.push('(');
            탐색(여는괄호수 - 1, 닫는괄호수, 경로, 결과);
            경로.pop();
        }
        if (닫는괄호수 > 0 && 닫는괄호수 > 여는괄호수) {
            경로.push(')');
            탐색(여는괄호수, 닫는괄호수 - 1, 경로, 결과);
            경로.pop();
        }
    }

    static List<String> solution(int N) {
        List<String> 결과 = new ArrayList<>();
        탐색(N, N, new Stack<>(), 결과);
        return 결과;
    }

    public static void main(String[] args) {
        for (int n = 1; n <= 4; ++n)
            System.out.println(solution(n));
    }
}
