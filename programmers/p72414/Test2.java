package programmers.p72414;
public class Test2 {

    static class Solution {

        int toSec(String hms) {
            int h = Integer.valueOf(hms.substring(0, 2));
            int m = Integer.valueOf(hms.substring(3, 5));
            int s = Integer.valueOf(hms.substring(6));
            return (h * 60 + m) * 60 + s;
        }

        String toHMS(int sec) {
            return String.format("%02d:%02d:%02d", sec / 3600, (sec % 3600) / 60, sec % 60);
        }

        public String solution(String play_time, String adv_time, String[] logs) {
            int 재생시간 = toSec(play_time);
            int 광고시간 = toSec(adv_time);
            int[] 시작_수 = new int[재생시간+1];
            int[] 종료_수 = new int[재생시간+1];

            for (int i = 0; i < logs.length; ++i) {
                int 시작시각 = toSec(logs[i].substring(0, 8));
                int 종료시각 = toSec(logs[i].substring(9));
                ++시작_수[시작시각];
                ++종료_수[종료시각];
            }
            int[] 재생 = new int[재생시간];
            재생[0] = 시작_수[0];
            for (int i = 1; i < 재생시간; ++i)
                재생[i] = 재생[i - 1] + 시작_수[i] - 종료_수[i];

            int 최대누적시간 = 0, 누적시간 = 0, 최대시각 = 0;
            for (int i = 0; i < 광고시간; ++i)
                누적시간 += 재생[i];
            최대누적시간 = 누적시간;
            for (int i = 1; i <= 재생시간 - 광고시간; ++i) {
                누적시간 -= 재생[i - 1];
                누적시간 += 재생[i + 광고시간 - 1];
                if (누적시간 > 최대누적시간) {
                    최대누적시간 = 누적시간;
                    최대시각 = i;
                }
            }
            return toHMS(최대시각);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("02:03:55", "00:14:15",
                new String[] {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29",
                              "01:30:59-01:53:29", "01:37:44-02:02:30"}));
        System.out.println(new Solution().solution("99:59:59", "25:00:00",
                new String[] {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59",
                              "11:00:00-31:00:00"}));
        System.out.println(new Solution().solution("50:00:00", "50:00:00",
                new String[] {"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"}));
    }
}