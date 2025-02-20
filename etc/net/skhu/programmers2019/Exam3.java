package net.skhu.programmers2019;

import java.util.Arrays;

public class Exam3 {

    /*
     * 직선1: (x1, y1) ~ (x2, y2)
     * 직선2: (x3, y3) ~ (x4, y4)
     */
    // 두 직선 모두 수직선이 아닌 경우: (x1 != x2) && (x3 != x4)
    static int 두직선의교점A(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        double a1 = (y2 - y1) / (double)(x2 - x1); // 직선1 기울기
        double a2 = (y4 - y3) / (double)(x4 - x3); // 직선2 기울기
        if (a1 == a2) { // 두 직선의 기울기가 같으면, 동일한 직선이거나, 평행선
            return (-a1 * x1 + y1 == -a2 * x3 + y3) ? 1 : 0; // 동일한 직선이면 1 아니면 0
        } else {
            // 두 직선의 교점
            double x = (a1 * x1 - a2 * x3 - y1 + y3) / (a1 - a2);
            double y = a1 * x - a1 * x1 + y1;
            // 교점이 두 직선에 포함되면 1, 범위 밖이면 0
            return Math.min(x1,x2) <= x && x <= Math.max(x1,x2) &&
                   Math.min(y1,y2) <= y && y <= Math.max(y1,y2) &&
                   Math.min(x3,x4) <= x && x <= Math.max(x3,x4) &&
                   Math.min(y3,y4) <= y && y <= Math.max(y3,y4) ? 1 : 0;
        }
    }

    // 두 번째 직선만 수직선인 경우. (x1 != x2) && (x3 == x4)
    static int 두직선의교점B(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        double a1 = (y2 - y1) / (double)(x2 - x1); // 직선1 기울기
        // 두 직선의 교점
        double x = x3;
        double y = a1 * x - a1 * x1 + y1;
        // 교점이 두 직선에 포함되면 1, 범위 밖이면 0
        return Math.min(x1,x2) <= x && x <= Math.max(x1,x2) &&
               Math.min(y1,y2) <= y && y <= Math.max(y1,y2) &&
               Math.min(x3,x4) <= x && x <= Math.max(x3,x4) &&
               Math.min(y3,y4) <= y && y <= Math.max(y3,y4) ? 1 : 0;
    }

    // 두 번째 모두 수직선인 경우. (x1 == x2) && (x3 == x4)
    static int 두직선의교점C(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        if (x1 != x3) return 0;
        // y좌표가 3개 뿐이므로, 아래의 두 if문은 언제나 false 이어서 불필요함.
        if (Math.min(y1, y2) > Math.max(y3, y4)) return 0;
        if (Math.max(y1, y2) < Math.min(y3, y4)) return 0;
        return 1;
    }

    /*
     * 직선1: (p1[0], p1[1]) ~ (p2[0], p2[1])
     * 직선2: (p3[0], p3[1]) ~ (p4[0], p4[1])
     */
    static int 두직선의교점(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (p1[X] != p2[X] && p3[X] != p4[X])
            return 두직선의교점A(p1[X], p1[Y], p2[X], p2[Y], p3[X], p3[Y], p4[X], p4[Y]);
        if (p1[X] != p2[X] && p3[X] == p4[X])
            return 두직선의교점B(p1[X], p1[Y], p2[X], p2[Y], p3[X], p3[Y], p4[X], p4[Y]);
        if (p1[X] == p2[X] && p3[X] != p4[X])
            return 두직선의교점B(p3[X], p3[Y], p4[X], p4[Y], p1[X], p1[Y], p2[X], p2[Y]);
        return 두직선의교점C(p1[X], p1[Y], p2[X], p2[Y], p3[X], p3[Y], p4[X], p4[Y]);
    }

    static final int X = 0, Y = 1;
    static final int[][] 좌표 = new int[][] {
        {-9, -9}, // 인덱스 0 값은 사용하지 않고, 인덱스 1~9 값만 사용한다.
        {-1, 1},  {0, 1},  {1, 1}, // 1, 2, 3 의 좌표
        {-1, 0},  {0, 0},  {1, 0}, // 4, 5, 6 의 좌표
        {-1, -1}, {0, -1}, {1, -1} // 7, 8, 9 의 좌표
    };

    static int[] solution(int[] pattern) {
        int 직선수 = pattern.length - 1;
        int[] 결과 = new int[직선수];
        for (int i = 0; i < 직선수; ++i) {
            int[] p1 = 좌표[pattern[i]];
            int[] p2 = 좌표[pattern[i + 1]];
            for (int j = 0; j < 직선수; ++j) {
                if (i == j) continue;
                int[] p3 = 좌표[pattern[j]];
                int[] p4 = 좌표[pattern[j + 1]];
                결과[i] += 두직선의교점(p1, p2, p3, p4);
            }
        }
        return 결과;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 5, 8, 9},
                {1, 6, 8, 3, 4},
                {2, 5, 1, 3},
                {6, 5, 7, 3, 9},
                {5, 3}
        };
        for (int[] pattern : a)
            System.out.println(Arrays.toString(solution(pattern)));
    }
}
