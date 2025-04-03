package programmers.e72412;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Test2 {

    static class Solution {

        int[] parseInfo(String info) {
            String[] a = info.split(" ");
            int[] 지원자 = new int[5];
            for (int j = 0; j < 4; ++j)
                지원자[j] = a[j].charAt(0);
            지원자[4] = Integer.valueOf(a[4]);
            return 지원자;
        }

        int[] parseQuery(String query) {
            String[] a = query.split(" and ");
            int[] 조건 = new int[5];
            for (int j = 0; j < 4; ++j) 조건[j] = a[j].charAt(0);
            조건[4] = Integer.valueOf(a[3].substring(a[3].lastIndexOf(' ') + 1));
            return 조건;
        }

        String toString(int[] a) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 4; ++i)
                builder.append((char)a[i]);
            return builder.toString();
        }

        HashMap<String, List<Double>> map;

        void 모든키조합(int[] 지원자, int index, int[] 키조합) {
            if (index >= 4) {
                String key = toString(키조합);
                List<Double> 점수목록 = map.get(key);
                if (점수목록 == null)
                    map.put(key, 점수목록 = new ArrayList<>());
                점수목록.add((double)지원자[4]);
                return;
            }
            키조합[index] = 지원자[index];
            모든키조합(지원자, index + 1, 키조합);

            int[] 새키조합 = Arrays.copyOf(키조합, 키조합.length);
            새키조합[index] = '-';
            모든키조합(지원자, index + 1, 새키조합);
        }

        public int[] solution(String[] info, String[] query) {
            map = new HashMap<>();
            for (String s : info) {
                int[] 지원자 = parseInfo(s);
                모든키조합(지원자, 0, new int[4]);
            }
            for (String key : map.keySet())
                Collections.sort(map.get(key));
            int[] result = new int[query.length];
            for (int i = 0; i < query.length; ++i) {
                int[] 쿼리 = parseQuery(query[i]);
                String key = toString(쿼리);
                List<Double> 점수목록 = map.get(key);
                if (점수목록 == null)
                    result[i] = 0;
                else {
                    int index = Collections.binarySearch(점수목록, 쿼리[4] - 0.5);
                    index = -(index + 1);
                    result[i] = 점수목록.size() - index;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210",
                "python frontend senior chicken 150", "cpp backend senior pizza 260",
                "java backend junior chicken 80", "python backend senior chicken 50"};

        String[] query = {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200","cpp and - and senior and pizza 250",
                "- and backend and senior and - 150","- and - and - and chicken 100",
                "- and - and - and - 150"};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(info, query)));
    }

}