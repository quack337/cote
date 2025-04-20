package baekjoon.b14501;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Counsel {
    int 시작일, 기간, 금액;
    public int 종료일() { return 시작일 + 기간 - 1; }
}

class Schedule {
    List<Counsel> 상담목록 = new ArrayList<>();

    public boolean 불가능한_일정인가() {
        if (상담목록.size() <= 1) return false;
        for (int i = 0; i < 상담목록.size() - 1; ++i) {
            Counsel Counsel1 = 상담목록.get(i);
            Counsel Counsel2 = 상담목록.get(i + 1);
            if (Counsel1.종료일() >= Counsel2.시작일) return true;
        }
        return false;
    }

    public int 금액합계() {
        int 합계 = 0;
        for (Counsel Counsel : 상담목록)
            합계 += Counsel.금액;
        return 합계;
    }

    public Schedule 추가(Counsel 상담)  { // immutable class
        Schedule schedule = new Schedule();
        schedule.상담목록.addAll(this.상담목록); // deep copy
        schedule.상담목록.add(상담);
        return schedule;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%d\n", 금액합계()));
        for (Counsel 상담 : 상담목록)
            builder.append(String.format("%d %d\n", 상담.시작일, 상담.기간));
        return builder.toString();
    }
}

public class Main {
    static final Schedule EMPTY_SCHEDULE = new Schedule();
    static int 퇴사일;
    static Counsel[] 상담목록;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            상담목록 = new Counsel[N];
            for (int i = 0; i < N; ++i) {
                Counsel 상담 = new Counsel();
                상담.시작일 = i + 1;
                상담.기간 = scanner.nextInt();
                상담.금액 = scanner.nextInt();
                상담목록[i] = 상담;
            }
            퇴사일 = 상담목록.length + 1;
            Schedule 최대금액일정 = find최대금액일정(EMPTY_SCHEDULE, 0);
            System.out.println(최대금액일정.금액합계());
        }
    }

    static Schedule find최대금액일정(Schedule 일정, int index) {
        if (일정.불가능한_일정인가()) return EMPTY_SCHEDULE;
        if (index >= 상담목록.length) return 일정;
        Counsel 상담 = 상담목록[index];
        if (상담.종료일() >= 퇴사일)
            return find최대금액일정(일정, index + 1);
        else {
            Schedule 일정1 = find최대금액일정(일정.추가(상담), index + 1);
            Schedule 일정2 = find최대금액일정(일정, index + 1);
            return 일정1.금액합계() > 일정2.금액합계() ? 일정1 : 일정2;
        }
    }
}