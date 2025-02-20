package net.skhu.kakao.t2021.ex3;

import java.util.Arrays;

public class Test1 {


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

        boolean compare(int[] 지원자, int[] 조건) {
            if (지원자[4] < 조건[4]) return false;
            for (int j = 0; j < 4; ++j)
                if (조건[j] != '-' && 조건[j] != 지원자[j])
                    return false;
            return true;
        }

        public int[] solution(String[] info, String[] query) {
            int[][] 지원자목록 = new int[info.length][];
            for (int i = 0; i < info.length; ++i)
                지원자목록[i] = parseInfo(info[i]);
            int[] result = new int[query.length];
            for (int q = 0; q < query.length; ++q) {
                int count = 0;
                int[] 조건 = parseQuery(query[q]);
                for (int[] 지원자 : 지원자목록)
                    if (compare(지원자, 조건)) ++count;
                result[q] = count;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210",
                "python frontend senior chicken 150","cpp backend senior pizza 260",
                "java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200","cpp and - and senior and pizza 250",
                "- and backend and senior and - 150","- and - and - and chicken 100",
                "- and - and - and - 150"};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(info, query)));
    }

}
