package programmers.p42746;

import java.util.ArrayList;
import java.util.Collections;

public class Main1 {

    static class Solution {

public String solution(int[] numbers) {
    ArrayList<String> list = new ArrayList<String>();
    for (int i : numbers)
        list.add(String.valueOf(i));
    Collections.sort(list, (a, b) -> {
        return (b + a).compareTo(a + b);
    });
    StringBuilder builder = new StringBuilder();
    for (String s : list)
        builder.append(s);
    return builder.toString();
}
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {6, 10, 2}));
        System.out.println(sol.solution(new int[] {3, 30, 34, 5, 9}));
    }
}