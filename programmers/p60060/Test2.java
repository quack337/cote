package programmers.p60060;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {

    static class Solution {

        Map<Integer, List<String>> split(String[] words) {
            Map<Integer, List<String>> map = new HashMap<>();
            for (String word : words) {
                List<String> list = map.get(word.length());
                if (list == null) {
                    list = new ArrayList<String>();
                    map.put(word.length(), list);
                }
                list.add(word);
            }
            return map;
        }

        public int[] solution(String[] words, String[] queries) {
            int[] answer = new int[queries.length];
            Map<Integer, List<String>> map = split(words);
            for (int i = 0; i < queries.length; ++i) {
                String query = queries[i];
                int count = 0, start = 0, end = 0, length = query.length();
                for (;  start < length && query.charAt(start) == '?'; ++start)
                    ;
                for (end = start; end < length && query.charAt(end) != '?'; ++end)
                    ;
                query = query.substring(start, end);
                List<String> list = map.get(length);
                if (list != null)
                    for (String word : list)
                        if (query.equals(word.substring(start, end)))
                                ++count;
                answer[i] = count;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?", "?????"};
        System.out.println(Arrays.toString(new Solution().solution(words, queries)));
    }
}