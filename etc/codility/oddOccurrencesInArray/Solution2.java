package codility.oddoccurrencesInarray;

import java.util.HashMap;

public class Solution2 {

    static int solution(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i : A) {
            if (map.containsKey(i)) {
                int count = map.get(i);
                map.put(i, count + 1);
            } else
                map.put(i, 1);
        }
        for (int i : map.keySet()) {
            int count = map.get(i);
            if (count % 2 == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = { 1, 32, 535, 6875, 71234, 1, 32, 6875, 71234, 535, 71234 };
        int n = solution(a);
        System.out.println(n);
    }
}