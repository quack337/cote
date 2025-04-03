package programmers.e17676;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    static class Solution {
        static class Span {
            int start, end;

            public Span(int start, int end) {
                this.start = start;
                this.end = end;
            }

            public Span beforeOrAfter1sec(int i) {
                return i == 0 ? new Span(start - 999, start) : // if i == 0 then 이전 1초 리턴
                                new Span(end, end + 999);      // else 이후 1초 리턴
            }

            public boolean overlap(Span span) {
                if (this.end < span.start) return false;
                if (this.start > span.end) return false;
                return true;
            }
        }

        List<Span> parsing(String[] lines) {
            var spans = new ArrayList<Span>();
            for (var s : lines) {
                s = s.replace("2016-09-15 ", "").replace("s", "");
                int eh = Integer.valueOf(s.substring(0, 2));
                int em = Integer.valueOf(s.substring(3, 5));
                int es = Integer.valueOf(s.substring(6, 8));
                int ems = Integer.valueOf(s.substring(9, 12));
                int end = ((eh * 60 + em) * 60 + es) * 1000 + ems;

                int ds = 0, dms = 0;
                s = s.substring(13);
                int index = s.indexOf('.');
                if (index == -1) ds = Integer.valueOf(s);
                else {
                    ds = Integer.valueOf(s.substring(0, index));
                    dms = Integer.valueOf(s.substring(index + 1));
                }
                int duration = ds * 1000 + dms;
                int start = end - duration + 1;
                spans.add(new Span(start, end));
            }
            return spans;
        }

        int getCount(List<Span> spans, Span span1) {
            int count = 0;
            for (var span2 : spans)
                if (span1.overlap(span2)) ++count;
            return count;
        }

        public int solution(String[] lines) {
            int max = 0;
            List<Span> spans = parsing(lines);
            for (var span : spans)
                for (int i = 0; i <= 1; ++i) { // 0 이면 이전 1초 else 이후 1초
                    int count = getCount(spans, span.beforeOrAfter1sec(i));
                    if (count > max) max = count;
                }
            return max;
        }
    }

    public static void main(String[] args) {
        String[] a1 = { "2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s" };
        String[] a2 = { "2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s" };
        String[] a3 = { "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s",
                        "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s",
                        "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s",
                        "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s",
                        "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s" };
        Solution s = new Solution();
        System.out.println(s.solution(a1));
        System.out.println(s.solution(a2));
        System.out.println(s.solution(a3));
    }
}