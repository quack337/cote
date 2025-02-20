package programmers.e42860;

public class Main2 {
    static class Solution {
        public int solution(String name) {
            final int N = name.length();
            int count1 = 0;
            for (char ch : name.toCharArray())
                count1 += Math.min(ch - 'A', 'Z' - ch + 1);

            int index1 = N - 1;
            while (index1 > 0 && name.charAt(index1) == 'A')
                --index1;
            int index2 = 1;
            while (index2 < N && name.charAt(index2) == 'A')
                ++index2;
            int count2 = Math.min(index1, N - index2);

            for (int i = 0; i < N; ++i) {
                int index3 = i + 1;
                while (index3 < N && name.charAt(index3) == 'A')
                    ++index3;
                count2 = Math.min(count2, i * 2 + (N - index3));
                count2 = Math.min(count2, i + (N - index3) * 2);
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
        System.out.println(sol.solution("ZZAAZ"));
    }
}
