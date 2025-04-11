package baekjoon.b1149;
import java.util.Scanner;

public class Main2 {
    static final int 빨강 = 0, 초록 = 1, 파랑 = 2;
    static int[][] 도색비용;
    static int[][] 리턴값_보관;
    static int N;

    static int 최소비용(int index, int 이전집_색) {
        if (index >= N) return 0;
        if (리턴값_보관[index][이전집_색] > 0) return 리턴값_보관[index][이전집_색];
        System.out.printf("%d %d\n", index, 이전집_색);
        int 최소값 = Integer.MAX_VALUE;
        for (int 색 = 0; 색 < 3; ++색) {
            if (index > 0 && 색 == 이전집_색) continue; // 이전 집과 동일한 색은 선택할 수 없음
            int 비용 = 도색비용[index][색] + 최소비용(index + 1, 색);
            if (비용 < 최소값) 최소값 = 비용;
        }
        return 리턴값_보관[index][이전집_색] = 최소값;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            N = scanner.nextInt();
            도색비용 = new int[N][3];
            리턴값_보관 = new int[N][3];
            for (int 집 = 0; 집 < N; ++집) {
                도색비용[집][빨강] = scanner.nextInt();
                도색비용[집][초록] = scanner.nextInt();
                도색비용[집][파랑] = scanner.nextInt();
            }
            System.out.println(최소비용(0, 0));
        }
    }
}