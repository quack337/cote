package programmers.p64065;

import java.util.Arrays;
import java.util.HashMap;

public class Main1 {
    static class Solution {
        public int[] solution(String s) {
            var map = new HashMap<Integer, Integer>();
            int number = 0;
            for (int i = 0; i < s.length(); ++i) {
                int digit = s.charAt(i) - '0';
                if (0 <= digit && digit <= '9')
                    number = number * 10 + digit;
                else if (number > 0) {
                    map.put(number, 1 + map.getOrDefault(number, 0));
                    number = 0;
                }
            }
            int[] answer = new int[map.size()];
            for (int key: map.keySet())
                answer[answer.length - map.get(key)] = key;
            return answer;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        System.out.println(Arrays.toString(sol.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
        System.out.println(Arrays.toString(sol.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
        System.out.println(Arrays.toString(sol.solution("{{20,111},{111}}")));
        System.out.println(Arrays.toString(sol.solution("{{123}}")));
        System.out.println(Arrays.toString(sol.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
    }
}