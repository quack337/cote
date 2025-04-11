package etcc.line.e2018;
import java.util.Scanner;
import java.util.Stack;

public class Schedule6 {

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

    static int 금액(Stack<Job> 일정) {
        int 합계 = 0;
        for (Job job : 일정)
            합계 += job.pay;
        return 합계;
    }

    static int 최대금액 = 0;
    static Stack<Job> 최대일정;

    @SuppressWarnings("unchecked")
    static void schedule(Job[] a, Stack<Job> 일정, int index) {
        if (일정불가능(일정)) return;
        if (index >= a.length) {
            int t = 금액(일정);
            if (t > 최대금액) {
                최대금액 = t;
                최대일정 = (Stack<Job>)일정.clone();
            }
            return;
        }
        일정.push(a[index]);
        schedule(a, 일정, index + 1);
        일정.pop();
        schedule(a, 일정, index + 1);
    }

    static void print(Stack<Job> 일정) {
        System.out.println(금액(일정));
        for (Job job : 일정)
            System.out.printf("%d %d\n", job.start, job.duration);
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
            print(최대일정);
        }
    }
}