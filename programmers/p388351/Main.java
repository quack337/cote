package programmers.p388351;
public class Main {

    static class Solution {
        int minutes(int hhmm) { // 현재 시각이 00:00 기준 몇 분 지났는가
            int 시 = hhmm / 100, 분 = hhmm % 100;
            return 시 * 60 + 분;
        }

        public int solution(int[] schedules, int[][] timelogs, int startday) {
            int answer = 0;
            for (int 직원 = 0; 직원 < schedules.length; ++직원)  {
                int 출근인정시각 = minutes(schedules[직원]) + 10;
                boolean 통과 = true;
                for (int 일 = 0; 일 < 7; ++일) {
                    int 요일 = (일 + startday - 1) % 7; // 월:0, 화:1 ... 토:5, 일:6
                    if (요일 >= 5) continue; // 토, 일 무시
                    int 출근시각 = minutes(timelogs[직원][일]);
                    if (출근시각 > 출근인정시각) { 통과 = false; break; }
                }
                if (통과) ++answer;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        var schedules = new int[][] {{700, 800, 1100}, {730, 855, 700, 720}};
        var timelogs = new int[][][] {
            {{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809},
             {1105, 1001, 1002, 600, 1059, 1001, 1100}},
            {{710, 700, 650, 735, 700, 931, 912}, {908, 901, 805, 815, 800, 831, 835},
            {705, 701, 702, 705, 710, 710, 711}, {707, 731, 859, 913, 934, 931, 905}}};
        var startday = new int[] {5, 1};

        for (int t = 0; t < schedules.length; ++t) {
            int answer = (new Solution()).solution(schedules[t], timelogs[t], startday[t]);
            System.out.println(answer);
        }
    }
}