package programmers.p92334;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    static class Solution {
        static class Report {
            HashSet<String> 신고한목록 = new HashSet<>(); // 이 유저가 신고한 ID 목록
            HashSet<String> 신고당한목록 = new HashSet<>(); // 이 유저를 신고한 ID 목록
        }

        public int[] solution(String[] id_list, String[] report, int k) {
             var map = new HashMap<String, Report>();
            for (String id : id_list)
                map.put(id, new Report());
            for (String r : report) {
                String[] a = r.split(" ");
                map.get(a[0]).신고한목록.add(a[1]);
                map.get(a[1]).신고당한목록.add(a[0]);
            }
            var answer = new ArrayList<Integer>();
            for (String id : id_list) {
                int count = 0;
                for (String user : map.get(id).신고한목록)
                    if (map.get(user).신고당한목록.size() >= k)
                        ++count;
                answer.add(count);
            }
            return answer.stream().mapToInt(i -> i).toArray();
        }
    }

    public static void main(String[] args) {
        String[] id_list1 = {"muzi", "frodo", "apeach", "neo"};
        String[] report1 = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(id_list1, report1, 2)));

        String[] id_list2 = {"con", "ryan"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        System.out.println(Arrays.toString(sol.solution(id_list2, report2, 3)));
    }
}