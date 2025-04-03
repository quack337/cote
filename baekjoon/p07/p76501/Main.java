package baekjoon.p07.p76501;

public class Main {

    static class Solution {
        public int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;
            for (int i = 0; i < absolutes.length; ++i)
                answer = answer + (absolutes[i] * (signs[i] ? +1 : -1));
            return answer;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        System.out.println(sol.solution(new int[] {4,7,12}, new boolean[] {true, false, true}));
        System.out.println(sol.solution(new int[] {1,2,3}, new boolean[] {false, false, true}));
    }
}