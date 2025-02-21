import java.util.HashMap;

public class Main {

    static class Solution {
        public String solution(String[] participant, String[] completion) {
            var map = new HashMap<String, Integer>();
            for (var s : participant)
                map.put(s, 1 + map.getOrDefault(s, 0));
            for (var s : completion) {
                map.put(s, map.get(s) - 1);
                if (map.get(s) == 0) map.remove(s);
            }
            return map.keySet().iterator().next();
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        System.out.println(sol.solution(new String[] {"leo", "kiki", "eden"},
                                        new String[] {"eden", "kiki"}));
        System.out.println(sol.solution(new String[] {"marina", "josipa", "nikola", "vinko", "filipa"},
                                        new String[] {"josipa", "filipa", "marina", "nikola"}));
        System.out.println(sol.solution(new String[] {"mislav", "stanko", "mislav", "ana"},
                                        new String[] {"stanko", "ana", "mislav"}));
    }
}