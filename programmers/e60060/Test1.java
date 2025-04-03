package programmers.e60060;

import java.util.Arrays;

public class Test1 {

    static class Solution {
        public int[] solution(String[] words, String[] queries) {
            int[] answer = new int[queries.length];
            for (int i = 0; i < queries.length; ++i) {
                String query = queries[i];
                int count = 0, start = 0, end = 0, length = query.length();
                for (;  start < length && query.charAt(start) == '?'; ++start)
                    ;
                for (end = start; end < length && query.charAt(end) != '?'; ++end)
                    ;
                query = query.substring(start, end);
                for (String word : words) {
                    if (word.length() != length) continue;
                    if (query.equals(word.substring(start, end)))
                            ++count;
                }
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