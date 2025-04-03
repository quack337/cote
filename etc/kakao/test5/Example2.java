package kakao.test5;

public class Example2 {

    static int getEndTime(String s) {
        int hour = Integer.valueOf(s.substring(11, 13));
        int min = Integer.valueOf(s.substring(14, 16));
        int sec = Integer.valueOf(s.substring(17, 19));
        int milisec = Integer.valueOf(s.substring(20, 23));
        return ((hour * 60 + min) * 60 + sec) * 1000 + milisec;
    }

    static int getStartTime(int endTime, String s) {
        int sec = Integer.valueOf(s.substring(24, 25));
        int milisec = s.length() > 26 ? Integer.valueOf(s.substring(26, s.length() - 1)) : 0;
        return endTime - (sec * 1000 + milisec) + 1;
    }

    static boolean overlap(int start1, int end1, int start2, int end2) {
        return (start1 <= start2 && start2 <= end1) ||
               (start1 <= end2 && end2 <= end1);
    }

    public static int solution(String[] a) {
        int[] startTime = new int[a.length];
        int[] endTime = new int[a.length];
        for (int i = 0; i < a.length; ++i) {
            endTime[i] = getEndTime(a[i]);
            startTime[i] = getStartTime(endTime[i], a[i]);
        }
        int maxCount = 0;
        for (int i = 0; i < a.length; ++i) {
            int count1 = 0;
            int count2 = 0;
            for (int j = 0; j < a.length; ++j) {
                if (overlap(startTime[i], startTime[i] + 999, startTime[j], endTime[j])) ++count1;
                if (overlap(endTime[i] - 999, endTime[i], startTime[j], endTime[j])) ++count2;
            }
            if (maxCount < count1) maxCount = count1;
            if (maxCount < count2) maxCount = count2;
        }
        return maxCount;
    }

    public static void main(String[] args) {
        String[] a1 = { "2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s" };
        String[] a2 = { "2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s" };
        String[] a3 = { "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s",
                        "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s",
                        "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s",
                        "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s",
                        "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s" };
        System.out.println(solution(a1));
        System.out.println(solution(a2));
        System.out.println(solution(a3));
    }
}