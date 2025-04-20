package programmers.p42860;
public class Main3 {
    static class Solution {
        public int solution(String name) {
            final int N = name.length();
            int count1 = 0;
            for (char ch : name.toCharArray())
                count1 += Math.min(ch - 'A', 'Z' - ch + 1);

            int count2 = N;
            for (int i = 0; i < N; ++i) {
                int index = i + 1;
                while (index < N && name.charAt(index) == 'A')
                    ++index;
                count2 = Math.min(count2, i * 2 + (N - index));
                count2 = Math.min(count2, i + (N - index) * 2);
            }
            return count1 + count2;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        System.out.println(sol.solution("JEROEN"));
        System.out.println(sol.solution("JAN"));

        System.out.println(sol.solution("A"));
        System.out.println(sol.solution("B"));
        System.out.println(sol.solution("Z"));
        System.out.println(sol.solution("ZAZ"));
        System.out.println(sol.solution("ZAAAAZ"));
    }
}