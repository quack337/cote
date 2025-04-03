package programmers.e84512;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    static class Solution {

        Set<String> 단어집합 = new TreeSet<String>();
        char[] 문자목록 = new char[] { 'A', 'E', 'I', 'O', 'U' };

        void 완전탐색(int length, String word) {
            if (length == 5) {
                if (word.length() > 0) 단어집합.add(word);
                return;
            }
            완전탐색(length + 1, word);
            for (char ch : 문자목록)
                완전탐색(length + 1, word + ch);
        }

        public int solution(String word) {
            완전탐색(0, "");
            List<String> 단어목록 = new ArrayList<>(단어집합);
            return 1 + Collections.binarySearch(단어목록, word);
        }
    }

    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.solution("AAAAE"));
        System.out.println(s.solution("AAAE"));
        System.out.println(s.solution("I"));
        System.out.println(s.solution("EIO"));
    }

}