package programmers.e92341;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class Main1 {

    static class Solution {

        public int[] solution(int[] fees, String[] records) {
            int 기본시간 = fees[0], 기본요금 = fees[1], 단위시간 = fees[2], 단위요금 = fees[3];
            var 주차시각 = new TreeMap<String, Integer>();
            var 누적시간 = new TreeMap<String, Integer>();
            for (String s : records) {
                String[] a = s.split(":| ");
                int 시 = Integer.valueOf(a[0]), 분 = Integer.valueOf(a[1]);
                String 차번호 = a[2];
                if ("IN".equals(a[3]))
                    주차시각.put(차번호, 시 * 60 + 분);
                else {
                    int 시간 = (시 * 60 + 분) - 주차시각.get(차번호);
                    누적시간.put(차번호, 시간 + 누적시간.getOrDefault(차번호, 0));
                    주차시각.remove(차번호);
                }
            }
            for (String 차번호 : 주차시각.keySet()) {
                int 시간 = (23 * 60 + 59) - 주차시각.get(차번호);
                누적시간.put(차번호, 시간 + 누적시간.getOrDefault(차번호, 0));
            }
            var list = new ArrayList<Integer>();
            for (String 차번호 : 누적시간.keySet()) {
                double 시간 = Math.max(0, 누적시간.get(차번호) - 기본시간);
                int 요금 = 기본요금 + (int)Math.ceil(시간 / 단위시간) * 단위요금;
                list.add(요금);
            }
            return list.stream().mapToInt(i -> i).toArray();
        }
    }

    public static void main(String[] args) {
        int[] f1 = {180, 5000, 10, 600};
        String[] r1 = {"05:34 5961 IN","06:00 0000 IN","06:34 0000 OUT","07:59 5961 OUT","07:59 0148 IN",
                       "18:59 0000 IN","19:09 0148 OUT","22:59 5961 IN","23:00 5961 OUT"};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(f1, r1)));

        int[] f2 = {120, 0, 60, 591};
        String[] r2 = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
        System.out.println(Arrays.toString(sol.solution(f2, r2)));

        int[] f3 = {1, 461, 1, 10};
        String[] r3 = {"00:00 1234 IN"};
        System.out.println(Arrays.toString(sol.solution(f3, r3)));
    }
}