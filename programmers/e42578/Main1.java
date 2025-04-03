package programmers.e42578;

import java.util.ArrayList;
import java.util.HashMap;

public class Main1 {

    static class Solution {

        public int solution(String[][] clothes) {
            var map = new HashMap<String, ArrayList<String>>();
            for (String[] a : clothes) {
                var list = map.get(a[1]);
                if (list == null) map.put(a[1], list = new ArrayList<String>());
                list.add(a[0]);
            }
            int answer = 1;
            for (String key : map.keySet())
                answer *= (map.get(key).size() + 1);
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