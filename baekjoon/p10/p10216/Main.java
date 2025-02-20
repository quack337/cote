package baekjoon.p10.p10216;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final int 미지정 = -1;

    static class Camp {
        int x, y, r, 그룹번호 = 미지정;
        List<Camp> 이웃 = new ArrayList<>();

        public Camp(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }

        public void 이웃추가(Camp c) {
            이웃.add(c);
        }

        public boolean 통신가능한가(Camp c) {
            double 거리 = Math.sqrt((x-c.x) * (x-c.x) + (y-c.y)*(y-c.y));
            return 거리 <= r + c.r;
        }
    }

    static Camp[] 진영;

    static void 이웃찾기() {
        for (int i = 0; i < 진영.length - 1; ++i)
            for (int j = i + 1; j < 진영.length; ++j)
                if (진영[i].통신가능한가(진영[j])) {
                    진영[i].이웃추가(진영[j]);
                    진영[j].이웃추가(진영[i]);
                }
    }

    static void DFS(Camp 현재진영, int 그룹번호) {
        if (현재진영.그룹번호 == 그룹번호) return;
        현재진영.그룹번호 = 그룹번호;
        for (Camp 이웃진영 : 현재진영.이웃)
            DFS(이웃진영, 그룹번호);
    }

    static int 그룹찾기() {
        int 그룹번호 = 0;
        for (Camp 현재진영 : 진영)
            if (현재진영.그룹번호 == 미지정)
                DFS(현재진영, ++그룹번호);
        return 그룹번호;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int T = scanner.nextInt();
            for (int t = 0; t < T; ++t) {
                int N = scanner.nextInt();
                진영 = new Camp[N];
                for (int i = 0; i < N; ++i) {
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    int r = scanner.nextInt();
                    진영[i] = new Camp(x, y, r);
                }
                이웃찾기();
                System.out.println(그룹찾기());
            }
        }
    }
}
