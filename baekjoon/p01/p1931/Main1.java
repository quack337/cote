package baekjoon.p01.p1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1 {
    static class Meeting {
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlap(Meeting meeting) {
            if (this.end <= meeting.start) return false;
            if (this.start >= meeting.end) return false;
            return true;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        Meeting[] A = new Meeting[N];
        for (int i = 0; i < N; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            A[i] = new Meeting(start, end);
        }
        Arrays.sort(A, (m1, m2) ->  m1.end - m2.end);

        int count = 0;
        Meeting previous = null;
        for (Meeting m : A)
            if (previous == null || previous.overlap(m) == false) {
                ++count;
                previous = m;
            }
        System.out.println(count);
    }
}