package net.skhu.line.e2018;

import java.util.Scanner;
import java.util.Stack;

public class Schedule3 {

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

    static void schedule(Job[] a, Stack<Job> 일정, int index) {
        if (index >= a.length) {
            System.out.println(일정); // 선택된 일정 출력
            return;
        }
        일정.push(a[index]); // 일정에 a[index] 알바를 추가하고
        schedule(a, 일정, index + 1); // 다음 알바를 선택하기 위한 재귀호출
        일정.pop();          // 일정에서 a[index] 알바를 제거하고
        schedule(a, 일정, index + 1); // 다음 알바를 선택하기 위한 재귀호출
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
            // a 배열의 알바 중에서 몇 개를 선택할 때,
            // 모든 가능한 조합 출력하기 재귀호출
            schedule(a, new Stack<Job>(), 0);
        }
    }
}
