package programmers.p118666;

import java.util.HashMap;

public class Main {

    static class Solution {
        public String solution(String[] survey, int[] choices) {
            var 점수맵 = new HashMap<Character, Integer>();
            for (int i = 0; i < survey.length; ++i) {
                if (choices[i] < 4) {
                    char 성격 = survey[i].charAt(0);
                    int 점수 = 4 - choices[i];
                    점수맵.merge(성격, 점수, Integer::sum);
                } else if (choices[i] > 4) {
                    char 성격 = survey[i].charAt(1);
                    int 점수 = choices[i] - 4;
                    점수맵.merge(성격, 점수, Integer::sum);
                }
            }
            final char[][] 성격목록 = {{'R','T'}, {'C','F'}, {'J','M'}, {'A','N'}};
            var answer = new StringBuilder();
            for (char[] 성격 : 성격목록) {
                int 점수0 = 점수맵.getOrDefault(성격[0], 0);
                int 점수1 = 점수맵.getOrDefault(성격[1], 0);
                answer.append(점수0 >= 점수1 ? 성격[0] : 성격[1]);
            }
            return answer.toString();
        }
    }

    public static void main(String[] args) {
        var s = new Solution();
        var survey1 = new String[] { "AN", "CF", "MJ", "RT", "NA" };
        var choices1 = new int[] { 5, 3, 2, 7, 5 };
        System.out.println(s.solution(survey1, choices1));

        var survey2 = new String[] { "TR", "RT", "TR" };
        var choices2 = new int[] { 7, 1, 3 };
        System.out.println(s.solution(survey2, choices2));

    }
}