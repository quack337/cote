package programmers.p67257;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main3 {

    static class Solution {
        static final int NUMBER = 0, OPERATOR = 1;

        static class Operand {
            int type, operator;
            long number;
            public Operand(long number) { this.type = NUMBER; this.number = number; }
            public Operand(char operator) { this.type = OPERATOR; this.operator = operator; }
        }

        Deque<Operand> parse(char[] expression) {
            var deque = new ArrayDeque<Operand>();
            int number = 0;
            for (char ch : expression) {
                if (ch >= '0' && ch <= '9')
                    number = (number * 10) + (ch - '0');
                else {
                    deque.add(new Operand(number));
                    deque.add(new Operand(ch));
                    number = 0;
                }
            }
            deque.add(new Operand(number));
            return deque;
        }

        Deque<Operand> calc(char operator, Deque<Operand> deque) {
            var newDeque = new ArrayDeque<Operand>();
            while (deque.size() > 0) {
                var operand = deque.removeFirst();
                if (operand.type == OPERATOR && operand.operator == operator) {
                    long number1 = newDeque.removeLast().number;
                    long number2 = deque.removeFirst().number;
                    long result = 0;
                    switch (operator) {
                    case '+': result = number1 + number2; break;
                    case '-': result = number1 - number2; break;
                    case '*': result = number1 * number2; break;
                    }
                    newDeque.addLast(new Operand(result));
                } else
                    newDeque.addLast(operand);
            }
            return newDeque;
        }

        public long solution(String expression) {
            var deque0 = parse(expression.toCharArray());
            var priorities = new String[] { "+-*", "+*-", "*+-", "*-+", "-*+", "-+*" };
            long max = 0;
            for (var priority : priorities) {
                Deque<Operand> deque = new ArrayDeque<Operand>(deque0);
                for (var operator : priority.toCharArray())
                    deque = calc(operator, deque);
                max = Math.max(max, Math.abs(deque.getFirst().number));
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