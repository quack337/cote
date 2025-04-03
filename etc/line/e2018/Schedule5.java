package line.e2018;

import java.util.Scanner;
import java.util.Stack;

public class Schedule5 {

    static class Job {
        int start, duration, pay;

        public Job(int start, int duration, int pay) {
            this.start = start;
            this.duration = duration;
            this.pay = pay;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d, %d)", start, duration, pay);
        }
    }

    static boolean 일정불가능(Stack<Job> 일정) {
        if (일정.size() <= 1) return false;
        for (int i = 0; i < 일정.size() - 1; ++i) {
            Job job1 = 일정.get(i);
            Job job2 = 일정.get(i + 1);
            if (job1.start + job1.duration > job2.start) return true;
        }
        return false;
    }

    static int 금액(Stack<Job> 일정) { // 일정에 포함된 알바 금액 합계
        int 합계 = 0;
        for (Job job : 일정)
            합계 += job.pay;
        return 합계;
    }

    static void schedule(Job[] a, Stack<Job> 일정, int index) {
        if (일정불가능(일정)) return;
        if (index >= a.length) {
            System.out.printf("%s %d\n", 일정, 금액(일정));
            return;
        }
        일정.push(a[index]);
        schedule(a, 일정, index + 1);
        일정.pop();
        schedule(a, 일정, index + 1);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            Job[] a = new Job[count];
            for (int i = 0; i < count; ++i) {
                int start = scanner.nextInt();
                int duration = scanner.nextInt();
                int pay = scanner.nextInt();
                a[i] = new Job(start, duration, pay);
            }
            schedule(a, new Stack<Job>(), 0);
        }
    }
}