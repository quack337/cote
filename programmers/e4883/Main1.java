package programmers.e4883;

public class Main1 {
    static class Solution {
        public String solution(String number, int k) {
            char[] A = new char[number.length()];
            int index = 0;
            for (int i = 0; i < number.length(); ++i) {
                char ch = number.charAt(i);
                while (k > 0 && index > 0 && A[index - 1] < ch) {
                    --index;
                    --k;
                }
                A[index++] = ch;
            }
            return new String(A, 0, index);
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        System.out.println(sol.solution("1924", 2));
        System.out.println(sol.solution("1231234", 3));
        System.out.println(sol.solution("4177252841", 4));
    }
}