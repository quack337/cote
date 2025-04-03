package kakao.test5;

import java.util.HashMap;
import java.util.Map;

public class Example5 {

    static Map<String, Integer> getMultiSet(String str) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length() - 1; ++i)
            if (Character.isAlphabetic(str.charAt(i)) &&
                Character.isAlphabetic(str.charAt(i + 1))) {
                String s = str.substring(i, i + 2).toLowerCase();
                Integer count = map.get(s);
                map.put(s, count == null ? 1 : count + 1);
            }
        return map;
    }

    static Map<String, Integer> get합집합(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();
        result.putAll(map1);
        for (String key : map2.keySet()) {
            Integer count1 = result.get(key);
            Integer count2 = map2.get(key);
            if (count1 == null) count1 = 0;
            result.put(key, Math.max(count1, count2));
        }
        return result;
    }

    static Map<String, Integer> get교집합(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();
        for (String key : map2.keySet()) {
            Integer count1 = map1.get(key);
            Integer count2 = map2.get(key);
            if (count1 != null && count2 != null)
                result.put(key, Math.min(count1, count2));
        }
        return result;
    }

    static int get원소수(Map<String, Integer> map) {
        int count = 0;
        for (String key : map.keySet())
            count += map.get(key);
        return count;
    }

    static int solution(String str1, String str2) {
        Map<String, Integer> map1 = getMultiSet(str1);
        Map<String, Integer> map2 = getMultiSet(str2);
        Map<String, Integer> 합집합 = get합집합(map1, map2);
        Map<String, Integer> 교집합 = get교집합(map1, map2);
        if (합집합.isEmpty()) return 65536;
        return get원소수(교집합) * 65536 / get원소수(합집합);
    }

    public static void main(String[] args) {
        String[] str1 = { "FRANCE", "handshake", "aa1+aa2", "E=M*C^2" };
        String[] str2 = { "french", "shake hands", "AAAA12", "e=m*c^2" };
        for (int i = 0; i < str1.length; ++i)
            System.out.println(solution(str1[i], str2[i]));
    }
}