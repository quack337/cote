package kakao.test4;

import java.util.Arrays;

public class Example1 {

    // HH:MM 형태의 시각을, 00:00 을 기준 몇 분이 지났는지 계산한다.
    // 예) "09:25" = (9시간 * 60분) + 25분 = 565
    static int hhmmToMinute(String time) {
        int hh = Integer.valueOf(time.substring(0, 2));
        int mm = Integer.valueOf(time.substring(3, 5));
        return hh * 60 + mm;
    }

    // 분을 HH:MM 형태의 시각으로 변환한다.
    static String minuteTohhmm(int minute) {
        return String.format("%02d:%02d", minute / 60, minute % 60);
    }

    static String solution(int n, int t, int m, String[] timetable) {
        int 버스탑승인원 = 0, 버스도착시각 = 0;
        Arrays.sort(timetable);
        int 마지막탑승자 = -1; // 버스에 마지막으로 탑승한 사람의 index
        for (int i = 0; i < n; ++i) {
            버스도착시각 = (9 * 60) + t * i;
            버스탑승인원 = 0;
            while (마지막탑승자+1 < timetable.length &&
                hhmmToMinute(timetable[마지막탑승자+1]) <= 버스도착시각 &&
                버스탑승인원 < m) {
                ++버스탑승인원;
                ++마지막탑승자;
            }
        }
        if (버스탑승인원 < m) return minuteTohhmm(버스도착시각);
        return minuteTohhmm(hhmmToMinute(timetable[마지막탑승자]) - 1);
    }

    public static void main(String[] args) {
        String[][] timetable = new String[][] {
            {"08:00", "08:01", "08:02", "08:03"},
            {"09:10", "09:09", "08:00"},
            {"09:00", "09:00", "09:00", "09:00"},
            {"00:01", "00:01", "00:01", "00:01", "00:01"},
            {"23:59"},
            {"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59",
             "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}
        };
        int[] n = { 1, 2, 2, 1, 1, 10 };
        int[] t = { 1, 10, 1, 1, 1, 60 };
        int[] m = { 5, 2, 2, 5, 1, 45 };

        for (int i = 0; i < timetable.length; ++i)
            System.out.println(solution(n[i], t[i], m[i], timetable[i]));
    }
}