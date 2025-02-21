import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class Main2 {

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
            var operators0 = Arrays.stream(expression.split("[0-9]+")).filter(s -> s.length() == 1)
                            .map(s -> s.charAt(0)).collect(Collectors.toCollection(ArrayDeque::new));
            var numbers0 = Arrays.stream(expression.split("[+*-]")).map(s -> Long.parseLong(s))
                            .collect(Collectors.toCollection(ArrayDeque::new));
            var priorities = new String[] { "+-*", "+*-", "*+-", "*-+", "-*+", "-+*" };
            long max = 0;
            for (var priority : priorities) {
                this.operators = operators0.clone();
                this.numbers = numbers0.clone();
                for (var operator : priority.toCharArray())
                    calc(operator);
                max = Math.max(max, Math.abs(numbers.getFirst()));
            }
            return max;
        }
    }

    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.solution("100-200*300-500+20"));
        System.out.println(s.solution("50*6-3*2"));
    }
}