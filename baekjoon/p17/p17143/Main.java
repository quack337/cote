package baekjoon.p17.p17143;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int 행수, 열수, 상어수;
    static List<Shark> 상어목록 = new ArrayList<>();

    static final int 북 = 1, 남 = 2, 동 = 3, 서 = 4;

    static class Shark implements Comparable<Shark> {
        int 행, 열, 속도, 방향, 크기;
        public Shark(int 행, int 열, int 속도, int 방향, int 크기) {
            this.행 = 행;
            this.열 = 열;
            this.속도 = 속도;
            this.방향 = 방향;
            this.크기 = 크기;
            if (방향 == 북 || 방향 == 남) 속도 = 속도 % (행수 * 2);
            if (방향 == 동 || 방향 == 서) 속도 = 속도 % (열수 * 2);
        }

        public void 이동() {
            switch (방향) {
            case 북: 행 -= 속도; break;
            case 남: 행 += 속도; break;
            case 서: 열 -= 속도; break;
            case 동: 열 += 속도; break;
            }
            while (true) {
            if (행 > 행수) { 행 = 2 * 행수 - 행; 방향 = 북; }
                else if (열 > 열수) { 열 = 2 * 열수 - 열; 방향 = 서; }
                else if (행 <= 0) { 행 = 2 - 행; 방향 = 남; }
                else if (열 <= 0) { 열 = 2 - 열; 방향 = 동; }
                else break;
            }
        }

        @Override
        public int compareTo(Shark 상어) { // ORDER BY 열, 행, 크기 DESC
            int r;
            if ((r = 열 - 상어.열) != 0) return r;
            if ((r = 행 - 상어.행) != 0) return r;
            return 상어.크기 - 크기;
        }
    }

    static Shark 낚시(int 열) {
        for (int i = 0; i < 상어목록.size(); ++i) {
            Shark 상어 = 상어목록.get(i);
            if (상어.열 == 열) {
                상어목록.remove(i);
                return 상어;
            }
        }
        return null;
    }

    static void 상어_이동() {
        for (Shark 상어 : 상어목록)
            상어.이동();
    }

    static void 서로잡아먹기() {
        Shark 직전상어 = null;
        Iterator<Shark> it = 상어목록.iterator();
        while (it.hasNext()) {
            Shark 상어 = it.next();
            if (직전상어 != null && 상어.행 == 직전상어.행 && 상어.열 == 직전상어.열)
                it.remove();
            else
                직전상어 = 상어;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            행수 = scanner.nextInt();
            열수 = scanner.nextInt();
            상어수 = scanner.nextInt();
            for (int i = 0; i < 상어수; ++i) {
                int 행 = scanner.nextInt();
                int 열 = scanner.nextInt();
                int 속도 = scanner.nextInt();
                int 방향 = scanner.nextInt();
                int 크기 = scanner.nextInt();
                상어목록.add(new Shark(행, 열, 속도, 방향, 크기));
            }
            Collections.sort(상어목록);
            int 합계 = 0;
            for (int 열 = 1; 열 <= 열수; ++열) {
                Shark 상어 = 낚시(열);
                if (상어 != null) 합계 += 상어.크기;
                상어_이동();
                Collections.sort(상어목록);
                서로잡아먹기();
            }
            System.out.println(합계);
        }
    }
}
