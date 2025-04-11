package etcc.net.skhu.brother;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Exam06 {

    static final int 티케팅성공시간 = 60;
    static final Log 종료로그 = new Log("종료 request 10:00:00");

    static class Log {
        String id, cmd;
        int time;

        Log(String log) {
            String[] a = log.split(" ");
            id = a[0];
            cmd = a[1];
            time = getTime(a[2]);
        }

        // 현재 시각을 자정 기준으로 초로 환산
        static int getTime(String hhmmss) {
            int hour = Integer.valueOf(hhmmss.substring(0, 2));
            int minute = Integer.valueOf(hhmmss.substring(3, 5));
            int second = Integer.valueOf(hhmmss.substring(6));
            return (hour * 60 + minute) * 60 + second;
        }
    }

    static boolean 티케팅성공(Log activeLog, Log currentLog, int ticketCount) {
        return ticketCount > 0 && activeLog != null &&
               currentLog.time - activeLog.time >= 티케팅성공시간;
    }

    static boolean 접속성공(Log activeLog, Log currentLog) {
        return activeLog == null || currentLog.time - activeLog.time >= 티케팅성공시간;
    }


    public static String[] solution(int ticketCount, String[] logs) {
        Set<String> result = new TreeSet<>();
        Log activeLog = null;
        for (String s : logs) {
            Log currentLog = new Log(s);
            if (currentLog.cmd.equals("leave")) {
                assert activeLog.id.equals(currentLog.id);
                activeLog = null;
            }
            else {
                assert currentLog.cmd.equals("request");
                if (티케팅성공(activeLog, currentLog, ticketCount)) {
                    --ticketCount;
                    result.add(activeLog.id);
                }
                if (접속성공(activeLog, currentLog))
                    activeLog = currentLog;
            }
        }
        if (티케팅성공(activeLog, 종료로그, ticketCount))
            result.add(activeLog.id);
        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args) {
        String[] logs = {
            "woni request 09:12:29",
            "brown request 09:23:11",
            "brown leave 09:23:44",
            "jason request 09:33:51",
            "jun request 09:33:56",
            "cu request 09:34:02"
        };
        System.out.println(Arrays.toString(solution(20, logs)));
    }
}