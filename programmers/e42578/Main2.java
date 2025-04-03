package programmers.e42578;

import java.util.HashMap;

public class Main2 {

    static class Solution {

        public int solution(String[][] clothes) {
            var map = new HashMap<String, Integer>();
            for (String[] a : clothes)
                map.put(a[1], 1 + map.getOrDefault(a[1], 0));
            int answer = 1;
            for (String key : map.keySet())
                answer *= (map.get(key) + 1);
            return answer - 1;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        System.out.println(sol.solution(new String[][]
            {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(sol.solution(new String[][]
            {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}}));
    }

}