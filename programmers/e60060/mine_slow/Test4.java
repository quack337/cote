package programmers.e60060.mine_slow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unchecked")
public class Test4 {

    static class Solution {

        Set<Integer>[] lengthSets = new HashSet[10000];
        Set<Integer>[][] charSets = new HashSet[10000][26];

        void createSets(String[] words) {
            for (int i = 0; i < words.length; ++i) {
                char[] word = words[i].toCharArray();
                if (lengthSets[word.length - 1] == null)
                    lengthSets[word.length - 1] = new HashSet<>();
                lengthSets[word.length - 1].add(i);

                for (int j = 0; j < word.length; ++j) {
                    if (word[j] == '?') continue;
                    if (charSets[j] == null) charSets[i] = new HashSet[26];
                    if (charSets[j][word[j] - 'a'] == null)
                        charSets[j][word[j] - 'a'] = new HashSet<>();
                    charSets[j][word[j] - 'a'].add(i);
                }
            }
        }

        public int[] solution(String[] words, String[] queries) {
            int[] answer = new int[queries.length];
            createSets(words);
            for (int i = 0; i < queries.length; ++i) {
                char[] query = queries[i].toCharArray();
                if (lengthSets[query.length - 1] == null) {
                    answer[i] = 0;
                    continue;
                }
                Set<Integer> resultSet = new HashSet<>();
                resultSet.addAll(lengthSets[query.length - 1]);
                for (int j = 0; j < query.length; ++j) {
                    if (query[j] == '?') continue;
                    Set<Integer> set = charSets[j][query[j] - 'a'];
                    if (set == null) {
                        resultSet.clear();
                        break;
                    }
                    resultSet.retainAll(set);
                    if (resultSet.size() == 0) break;
                }
                answer[i] = resultSet.size();
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