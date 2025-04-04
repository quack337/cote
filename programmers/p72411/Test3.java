package programmers.p72411;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test3 {

    static class Solution {
        List<Set<Character>> 주문목록;
        List<Character> 메뉴목록;
        List<Set<Character>> 최대주문목록;
        int 최대주문수;

        Set<Character> toSet(String str) {
            return str.chars().mapToObj(e->(char)e).collect(Collectors.toSet());
        }

        String toString(Set<Character> set) {
           List<Character> list = new ArrayList<>(set);
           Collections.sort(list);
           StringBuilder builder = new StringBuilder();
           for (char c : list) builder.append(c);
           return builder.toString();
        }

        int 몇번주문되었나(Set<Character> 메뉴조합) {
            int 주문수 = 0;
            for (var 주문 : 주문목록)
              if (주문.containsAll(메뉴조합)) ++주문수;
            return 주문수;
        }

        void 모든_메뉴조합(int 메뉴크기, int index, Set<Character> 메뉴조합) {
            if (메뉴조합.size() >= 1 && 몇번주문되었나(메뉴조합) < 최대주문수) return;
            if (메뉴목록.size() - index < 메뉴크기 - 메뉴조합.size()) return;
            if (메뉴조합.size() == 메뉴크기) {
                int 주문수 = 몇번주문되었나(메뉴조합);
                if (주문수 > 최대주문수) {
                    최대주문목록.clear();
                    최대주문수 = 주문수;
                }
                if (주문수 == 최대주문수) 최대주문목록.add(메뉴조합);
                return;
            }
            모든_메뉴조합(메뉴크기, index + 1, 메뉴조합);

            Set<Character> 새메뉴조합 = new HashSet<>(메뉴조합);
            새메뉴조합.add(메뉴목록.get(index));
            모든_메뉴조합(메뉴크기, index + 1, 새메뉴조합);
        }

        public String[] solution(String[] orders, int[] course) {
            List<String> result = new ArrayList<>();
            주문목록 = new ArrayList<>();
            for (String order : orders)
                주문목록.add(toSet(order));
            Set<Character> 합집합 = new HashSet<>();
            for (Set<Character> 주문 : 주문목록)
                합집합.addAll(주문);
            메뉴목록 = new ArrayList<>(합집합);
            for (int 메뉴크기 : course) {
                최대주문수 = 2;
                최대주문목록 = new ArrayList<>();
                모든_메뉴조합(메뉴크기, 0, new HashSet<>());
                if (최대주문수 > 1)
                    for (var 주문 : 최대주문목록)
                        result.add(toString(주문));
            }
            Collections.sort(result);
            return result.toArray(new String[0]);
        }
    }

    public static void main(String[] args) {
        String[][] a1 = {{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
           {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, {"XYZ", "XWY", "WXA"}};
        int[][] a2 = {{2,3,4}, {2,3,5}, {2,3,4}};
        Solution s = new Solution();
        for (int i = 0; i < a1.length; ++i)
            System.out.println(Arrays.toString(s.solution(a1[i], a2[i])));
    }
}