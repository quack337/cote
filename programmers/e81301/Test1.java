package net.skhu.kakao.i2021.ex1;

public class Test1 {

    static class Solution {
        public int solution(String s) {
            String[] a = { "zero", "one", "two", "three", "four", "five", "six",
                           "seven", "eight", "nine" };
            for (int i = 0; i < a.length; ++i)
                s = s.replaceAll(a[i], String.valueOf(i));
            return Integer.valueOf(s);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("one4seveneight"));
        System.out.println(solution.solution("23four5six7"));
        System.out.println(solution.solution("2three45sixseven"));
        System.out.println(solution.solution("123"));
    }
}
