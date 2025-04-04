package programmers.p67258;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main2 {

    static class Solution {
        String[] gems; // 입력 배열
        int gemCount;  // 보석 종류 수

        void add(HashMap<String, Integer> map, String gem) {
            map.put(gem, map.getOrDefault(gem, 0) + 1);
        }

        void remove(HashMap<String, Integer> map, String gem) {
            map.put(gem, map.getOrDefault(gem, 0) - 1);
            if (map.get(gem) == 0)
                map.remove(gem);
        }

        int solution(int size) {
            var map = new HashMap<String, Integer>();
            for (int i = 0; i < size; ++i)
                map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            if (map.size() == gemCount) return 0;
            for (int i = 1; i < gems.length - size + 1; ++i) {
                remove(map, gems[i - 1]);
                add(map, gems[i + size - 1]);
                if (map.size() == gemCount) return i;
            }
            return -1;
        }

        public int[] solution(String[] gems) {
            this.gems = gems;
            this.gemCount = new HashSet<String>(Arrays.asList(gems)).size();
            for (int size = gemCount; size <= gems.length; ++size) {
                int i = solution(size);
                if (i >= 0) return new int[] { i + 1, i + size };
            }
            return null;
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