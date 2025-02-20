package programmers.e42746;

import java.util.ArrayList;
import java.util.Collections;

public class Main2 {

    static class Solution {

        public String solution(int[] numbers) {
            ArrayList<String> list = new ArrayList<String>();
            for (int i : numbers)
                list.add(String.valueOf(i));
            Collections.sort(list, (a, b) -> (b + a).compareTo(a + b));
            StringBuilder builder = new StringBuilder();
            for (String s : list)
                builder.append(s);
            String s = builder.toString();
            return (s.charAt(0) == '0') ? "0" : s;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {6, 10, 2}));
        System.out.println(sol.solution(new int[] {3, 30, 34, 5, 9}));
        System.out.println(sol.solution(new int[] {0, 0}));
    }
}
