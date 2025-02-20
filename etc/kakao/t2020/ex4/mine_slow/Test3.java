package net.skhu.kakao.t2020.ex4.mine_slow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unchecked")
public class Test3 {

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

        void print() {
            for (int i = 0; i < lengthSets.length; ++i) {
                Set<Integer> set = lengthSets[i];
                if (set != null)
                    System.out.printf("%d %s\n", i, set);
            }
            System.out.println("----------");
            for (int i = 0; i < charSets.length; ++i) {
                if (charSets[i] == null) continue;
                for (int j = 0; j < charSets[i].length; ++j) {
                    Set<Integer> set = charSets[i][j];
                    if (set != null)
                        System.out.printf("%d %c %s\n", i, 'a' + j, set);
                }
            }
            System.out.println("----------");
        }

        public int[] solution(String[] words, String[] queries) {
            int[] answer = new int[queries.length];
            createSets(words);

            print();
            return answer;
        }
    }

    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?", "?????"};
        System.out.println(Arrays.toString(new Solution().solution(words, queries)));
    }
}
