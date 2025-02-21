import java.util.LinkedList;

public class Main1 {

    static class Solution {
        static boolean 균형(LinkedList<Character> list) {
            LinkedList<Character> stack = new LinkedList<>();
            for (char c : list) {
                switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.size() == 0 || stack.pop() != '(')
                        return false;
                    break;
                case '}':
                    if (stack.size() == 0 || stack.pop() != '{')
                        return false;
                    break;
                case ']':
                    if (stack.size() == 0 || stack.pop() != '[')
                        return false;
                    break;
                }
            }
            return stack.size() == 0;
        }

        public int solution(String s) {
            LinkedList<Character> list = new LinkedList<>();
            for (int i = 0; i < s.length(); ++i)
                list.add(s.charAt(i));
            int 회전 = 0, 답 = 0;
            while (true) {
                if (균형(list)) ++답;
                if (++회전 >= s.length()) break;
                char c = list.removeFirst();
                list.add(c);
            }
            return 답;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("[](){}"));
        System.out.println(sol.solution("}]()[{"));
        System.out.println(sol.solution("[)(]"));
        System.out.println(sol.solution("}}}"));
        //
        System.out.println(sol.solution("}"));
        System.out.println(sol.solution("{"));
    }

}