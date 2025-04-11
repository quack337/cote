package etcc.line.e2018.schedule7;
import java.util.Scanner;
import etcc.line.e2018.schedule7.Schedule.Job;

public class MaxSchedule {

    static final Schedule EMPTY_SCHEDULE = new Schedule();

    static Schedule findMaxSchedule(Job[] a, Schedule 일정, int index) {
        if (일정.isImpossible()) return EMPTY_SCHEDULE;
        if (index >= a.length) return 일정;

        Schedule 일정1 = findMaxSchedule(a, 일정.add(a[index]), index + 1);
        Schedule 일정2 = findMaxSchedule(a, 일정, index + 1);
        return 일정1.amount() > 일정2.amount() ? 일정1 : 일정2;
    }

    static Job[] getJobData() {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            Job[] a = new Job[count];
            for (int i = 0; i < count; ++i) {
                int start = scanner.nextInt();
                int duration = scanner.nextInt();
                int pay = scanner.nextInt();
                a[i] = new Job(start, duration, pay);
            }
            return a;
        }
    }

    public static void main(String[] args) {
        System.out.println(findMaxSchedule(getJobData(), EMPTY_SCHEDULE, 0));
    }
}