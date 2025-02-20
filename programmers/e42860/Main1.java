package programmers.e42860;

public class Main1 {
    static class Solution {
        public int solution(String name) {
            final int N = name.length();
            int count = 0;
            for (char ch : name.toCharArray())
                count += Math.min(ch - 'A', 'Z' - ch + 1);

            int index1 = N - 1;
            while (index1 > 0 && name.charAt(index1) == 'A')
                --index1;
            int index2 = 1;
            while (index2 < N && name.charAt(index2) == 'A')
                ++index2;
            count += Math.min(index1, N - index2);
            return count;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        System.out.println(sol.solution("JEROEN"));
        System.out.println(sol.solution("JAN"));
        System.out.println(sol.solution("ZZAAZ"));
    }

}
