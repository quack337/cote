package programmers.e67258;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main3 {

    static class Solution {
        String[] gems; // 입력 배열
        int gemCount;  // 보석 종류 수
        int answerFrom, answerSize;

        void add(HashMap<String, Integer> map, String gem) {
            map.put(gem, map.getOrDefault(gem, 0) + 1);
        }

        void remove(HashMap<String, Integer> map, String gem) {
            map.put(gem, map.getOrDefault(gem, 0) - 1);
            if (map.get(gem) == 0)
                map.remove(gem);
        }

        public void solution() {
            var map = new HashMap<String, Integer>();
            int from = 0, to = 0;
            map.put(gems[from], 1);
            while (true) {
                if (map.size() < gemCount) {
                    ++to;
                    if (to >= gems.length) break;
                    add(map, gems[to]);
                } else {
                    int size = to - from + 1;
                    if (size < answerSize) {
                        answerFrom = from;
                        answerSize = size;
                    }
                    remove(map, gems[from]);
                    ++from;
                }
            }
        }

        public int[] solution(String[] gems) {
            this.gems = gems;
            this.gemCount = new HashSet<String>(Arrays.asList(gems)).size();
            this.answerFrom = 0; this.answerSize = gems.length;
            solution();
            return new int[] { answerFrom + 1, answerFrom + answerSize };
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var gemslist = new String[][] {{ "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" },
            {"AA", "AB", "AC", "AA", "AC"},
            {"XYZ", "XYZ", "XYZ"},
            {"ZZZ", "YYY", "NNNN", "YYY", "BBB"}};
        for (var gems : gemslist)
            System.out.println(Arrays.toString(sol.solution(gems)));
    }
}
