package line.e2018.schedule7;

import java.util.ArrayList;

public class Schedule {

    public static class Job {
        int start, duration, pay;

        public Job(int start, int duration, int pay) {
            this.start = start;
            this.duration = duration;
            this.pay = pay;
        }
    }

    ArrayList<Job> list = new ArrayList<>();

    public boolean isImpossible() {
        if (list.size() <= 1) return false;
        for (int i = 0; i < list.size() - 1; ++i) {
            Job job1 = list.get(i);
            Job job2 = list.get(i + 1);
            if (job1.start + job1.duration > job2.start) return true;
        }
        return false;
    }

    public int amount() {
        int sum = 0;
        for (Job job : list)
            sum += job.pay;
        return sum;
    }

    public Schedule add(Job job)  {
        Schedule schedule = this.clone();
        schedule.list.add(job);
        return schedule;
    }

    @Override
    public Schedule clone() {
        Schedule schedule = new Schedule();
        schedule.list.addAll(this.list);
        return schedule;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%d\n", amount()));
        for (Job job : list)
            builder.append(String.format("%d %d\n", job.start, job.duration));
        return builder.toString();
    }
}