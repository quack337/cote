package baekjoon.b02.p2261;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static final int X = 0, Y = 1;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int get(int 축) {
            return 축 == X ? x : y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Point))
                return false;
            Point p = (Point) obj;
            return x == p.x && y == p.y;
        }
    }

    static int 거리(Point a, Point b) {
        int x = a.x - b.x;
        int y = a.y - b.y;
        return x * x + y * y;
    }

    static void swap(Point[] P, int i, int j) {
        Point temp = P[i];
        P[i] = P[j];
        P[j] = temp;
    }

    static int 중간값(Point[] P, int start, int end, int 축) {
        int 최대 = Integer.MIN_VALUE, 최소 = Integer.MAX_VALUE;
        for (int i = start; i <= end; ++i) {
            int 좌표 = P[i].get(축);
            if (좌표 < 최소) 최소 = 좌표;
            if (좌표 > 최대) 최대 = 좌표;
        }
        return (최대 + 최소) / 2;
    }

    static int 분할(Point[] P, int start, int end, int 축, int 기준좌표) {
        int i = start - 1;
        for (int j = start; j <= end; ++j)
            if (P[j].get(축) < 기준좌표)
                swap(P, ++i, j);
        return i + 1;
    }

    static Point[] 가까운점들(Point[] P, int start, int end, int 축, int 기준좌표, int 기준거리) {
        ArrayList<Point> list = new ArrayList<>();
        for (int i = start; i <= end; ++i) {
            int 좌표 = P[i].get(축);
            int 거리 = (좌표 - 기준좌표) * (좌표 - 기준좌표);
            if (거리 < 기준거리)
                list.add(P[i]);
        }
        return list.toArray(new Point[list.size()]);
    }

    static int 최소거리_반복문구현(Point[] P, int start, int end) {
        int 최소 = Integer.MAX_VALUE;
        for (int i = start; i <= end - 1; ++i)
            for (int j = i + 1; j <= end; ++j) {
                int 거리 = 거리(P[i], P[j]);
                if (거리 < 최소) 최소 = 거리;
            }
        return 최소;
    }

    static int 최소거리(Point[] P, int start, int end, int 축) {
        int size = (end - start) + 1;
        if (size <= 1) return Integer.MAX_VALUE;
        if (size == 2) return 거리(P[start], P[end]);
        if (size <= 6) return 최소거리_반복문구현(P, start, end);

        int 기준좌표 = 중간값(P, start, end, 축);
        int middle = 분할(P, start, end, 축, 기준좌표);
        int 다음축 = (축 == X) ? Y : X;

        if (middle == start)
            return 최소거리(P, start, end, 다음축);
        else {
            int 거리1 = 최소거리(P, start, middle - 1, 다음축);
            int 거리2 = 최소거리(P, middle, end, 다음축);
            int 거리 = Math.min(거리1, 거리2);
            Point[] Q = 가까운점들(P, start, end, 축, 기준좌표, 거리);
            if (size == Q.length)
                return 최소거리(P, start, end, 다음축);
            else {
                int 거리3 = 최소거리(Q, 0, Q.length - 1, 다음축);
                return Math.min(거리, 거리3);
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            Point[] P = new Point[N];
            HashSet<Point> set = new HashSet<>();
            for (int i = 0; i < N; ++i) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                Point p = new Point(x, y);
                if (set.contains(p)) { // 좌표가 같은 점을 또 발견함.
                    System.out.println(0); // 좌표가 같은 두 점의 거리는 0 이다.
                    return; // 종료.
                }
                set.add(p);
                P[i] = p;
            }
            System.out.println(최소거리(P, 0, N - 1, X));
        }
    }
}