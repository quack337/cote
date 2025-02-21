/*


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main1 {

    static class Solution {
        int[] 단어번호목록;
        int 현재번호;
        char[] 문장;

        boolean isUpper(char c) {
            return 'A' <= c && c <= 'Z';
        }

        boolean isLower(char c) {
            return 'a' <= c && c <= 'z';
        }

        boolean 단어문자표시(int index) {
            if (isUpper(문장[index]) == false) return false;
            if (단어번호목록[index] != 0) return false;
            단어번호목록[index] = 현재번호;
            return true;
        }

        boolean 규칙1단어표시(List<Integer> list) {
            for (int i : list)
                if (단어문자표시(i - 1) == false)
                    return false;
            if (단어문자표시(list.get(list.size() - 1)) == false)
                return false;
            return true;
        }

        boolean 규칙2단어표시(int index1, int index2) {
            for (int i = index1 + 1; i < index2; ++i)
            for (int i : list)
                if (단어문자표시(i - 1) == false)
                    return false;
            if (단어문자표시(list.get(list.size() - 1)) == false)
                return false;
            return true;
        }

        public String solution(String sentence) {
            final int N = 'z' - 'a' + 1;
            var map = new HashMap<Character, List<Integer>>();
            문장 = sentence.toCharArray();
            for (int i = 0; i < 문장.length; ++i) {
                char c = 문장[i];
                if (isLower(c)) {
                    List<Integer> list = map.get(c);
                    if (list == null) {
                        list = new ArrayList<Integer>();
                        map.put(c, list);
                    }
                    list.add(i);
                }
            }

            단어번호목록 = new int[문장.length];
            현재번호 = 1;
            int[] 규칙 = new int[N];
            for (int i = 0; i < N; ++i) {
                char c = (char)('a' + i);
                List<Integer> list = map.get(c);
                if (list == null) continue;
                if (list.size() == 1 || list.size() >= 3) {
                    규칙[i] = 1;
                    if (규칙1단어표시(list) == false) return "invalid";
                } else { // list.size() == 2
                    int index1 = list.get(0), index2 = list.get(1);
                    int distance = index2 - index1;
                    if (distance > 2) 규칙[i] = 2;
                    else if (distance == 1) return "invalid";
                    else { // distance == 2
                        if (index1 == 0 || isLower(문장[index1])) 규칙[i] = 2;
                        if (index2 == 문장.length - 1 || isLower(문장[index2])) 규칙[i] = 2;
                    }
                }
            }


            String answer = "";
            return answer;
        }
    }

    public static void main(String[] args) {

    }

}
*/