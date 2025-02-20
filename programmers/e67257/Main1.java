package programmers.e67257;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class Main1 {

    static class Solution {
        Deque<Character> operators;
        Deque<Long> numbers;

        void calc(char operator) {
            var operators2 = new ArrayDeque<Character>();
            var numbers2 = new ArrayDeque<Long>();
            while (operators.size() > 0) {
                char op = operators.removeFirst();
                if (op == operator) {
                    long a = numbers.removeFirst();
                    long b = numbers.removeFirst();
                    long newValue = 0;
                    switch (operator) {
                    case '+': newValue = a + b; break;
                    case '-': newValue = a - b; break;
                    case '*': newValue = a * b; break;
                    }
                    numbers.addFirst(newValue);
                } else {
                    operators2.addLast(op);
                    numbers2.addLast(numbers.removeFirst());
                }
            }
            numbers2.addLast(numbers.removeFirst());
            operators = operators2;
            numbers = numbers2;
        }

        public long solution(String expression) {
            operators = Arrays.stream(expression.split("[0-9]+")).filter(s -> s.length() == 1)
                            .map(s -> s.charAt(0)).collect(Collectors.toCollection(ArrayDeque::new));
            numbers = Arrays.stream(expression.split("[+*-]")).map(s -> Long.parseLong(s))
                            .collect(Collectors.toCollection(ArrayDeque::new));
            return 0;
        }
    }

    public static void main(String[] args) {
        var s = new Solution();
        s.solution("1+2*3-4");
        s.calc('+');
        System.out.println(s.operators);
        System.out.println(s.numbers);

        s.solution("1+2+3+4");
        s.calc('+');
        System.out.println(s.operators);
        System.out.println(s.numbers);
    }

}
