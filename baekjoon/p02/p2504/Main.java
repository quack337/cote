package baekjoon.p02.p2504;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static int PS(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int 곱 = 1;    // 중첩된 괄호에 의해 곱해져야할 값
        int 결과 = 0;  // 계산 결과 값
        char 직전문자 = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
            case '(':
                stack.push(c);
                곱 *= 2; // 중첩된 괄호에 의해 곱해져야할 값
                break;
            case '[':
                stack.push(c);
                곱 *= 3; // 중첩된 괄호에 의해 곱해져야할 값
                break;
            case ')':
                if (stack.size() == 0 || stack.pop() != '(') return 0;
                if (직전문자 == '(') 결과 += 곱;      // () 이면
                곱 /= 2;  // 괄호가 한 개 닫혔으므로, 곱해져야할 값도 줄어든다
                break;
            case ']':
                if (stack.size() == 0 || stack.pop() != '[') return 0;
                if (직전문자 == '[') 결과 += 곱;      // [] 이면
                곱 /= 3;  // 괄호가 한 개 닫혔으므로, 곱해져야할 값도 줄어든다
                break;
            }
            직전문자 = c;
        }
        return stack.isEmpty() ? 결과 : 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        System.out.println(PS(s));
    }
}
