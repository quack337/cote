package programmers.p150370;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    static class Solution {
        static class Date {
            int year, month, day;

            public Date(String s) {
                year = Integer.parseInt(s.substring(0, 4));
                month = Integer.parseInt(s.substring(5, 7));
                day = Integer.parseInt(s.substring(8, 10));
            }

            public int subtract(Date date) {
                int temp = this.year - date.year;
                temp = temp * 12 + this.month - date.month;
                return temp * 28 + this.day - date.day;
            }
        }

        public int[] solution(String today, String[] terms, String[] privacies) {
            Date 오늘 = new Date(today);
            var 보유기간월 = new HashMap<Character, Integer>();
            for (String s : terms)
                보유기간월.put(s.charAt(0), Integer.parseInt(s.substring(2)));
            var result = new ArrayList<Integer>();
            for (int i = 0; i < privacies.length; ++i) {
                Date 수집일 = new Date(privacies[i]);
                char 약관 = privacies[i].charAt(11);
                int 보유기간일 = 보유기간월.get(약관) * 28;
                if (오늘.subtract(수집일) >= 보유기간일)
                    result.add(i + 1);
            }
            return result.stream().mapToInt(i -> i).toArray();
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var today = "2022.05.19";
        var terms = new String[] { "A 6", "B 12", "C 3" };
        var privacies = new String[] { "2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C" };
        System.out.println(Arrays.toString(sol.solution(today, terms, privacies)));

        today = "2020.01.01";
        terms = new String[] { "Z 3", "D 5" };
        privacies = new String[] { "2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z" };
        System.out.println(Arrays.toString(sol.solution(today, terms, privacies)));
    }
}