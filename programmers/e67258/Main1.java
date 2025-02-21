import java.util.Arrays;
import java.util.HashSet;

public class Main1 {

    static class Solution {
        String[] gems; // 입력 배열
        int gemCount;  // 보석 종류 수

        int solution(int size) {
            for (int i = 0; i < gems.length - size + 1; ++i) {
                String[] gems_range = Arrays.copyOfRange(gems, i, i + size);
                int count = new HashSet<String>(Arrays.asList(gems_range)).size();
                if (count == gemCount) return i;
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