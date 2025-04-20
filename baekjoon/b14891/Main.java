package baekjoon.b14891;
import java.util.Scanner;

public class Main {
    static final int 톱니바퀴수 = 4, 톱니수 = 8, 시계방향 = 1, 반시계방향 = -1;
    static char[][] 톱니바퀴;

    static void 왼쪽으로회전(int 번호) {
        char[] a = 톱니바퀴[번호];
        char temp = a[0];
        for (int i = 0; i < 톱니수 - 1; ++i)
            a[i] = a[i + 1];
        a[톱니수 - 1] = temp;
    }

    static void 오른쪽으로회전(int 번호) {
        char[] a = 톱니바퀴[번호];
        char temp = a[톱니수 - 1];
        for (int i = 톱니수 - 1; i > 0; --i)
            a[i] = a[i - 1];
        a[0] = temp;
    }

    static void 회전(int 번호, int 방향) {
        if (방향 == 시계방향) 오른쪽으로회전(번호);
        else 왼쪽으로회전(번호);
    }

    static void 뒤쪽_톱니바퀴_회전(int 번호, int 방향) {
        if (번호 >= 톱니바퀴수) return;
        if (톱니바퀴[번호 - 1][2] == 톱니바퀴[번호][6]) return;
        방향 *= -1;
        뒤쪽_톱니바퀴_회전(번호 + 1, 방향);
        회전(번호, 방향);
    }

    static void 앞쪽_톱니바퀴_회전(int 번호, int 방향) {
        if (번호 < 0) return;
        if (톱니바퀴[번호][2] == 톱니바퀴[번호 + 1][6]) return;
        방향 *= -1;
        앞쪽_톱니바퀴_회전(번호 - 1, 방향);
        회전(번호, 방향);
    }

    static void 회전시작(int 번호, int 방향) {
        앞쪽_톱니바퀴_회전(번호 - 1, 방향);
        뒤쪽_톱니바퀴_회전(번호 + 1, 방향);
        회전(번호, 방향);
    }

    static int 점수() {
        int 합계 = 0;
        for (int i = 0; i < 톱니바퀴수; ++i)
            합계 += (톱니바퀴[i][0] == '1') ?  (1 << i) : 0;
        return 합계;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            톱니바퀴 = new char[톱니바퀴수][];
            for (int i = 0; i < 톱니바퀴수; ++i)
                톱니바퀴[i] = scanner.next().toCharArray();
            int N = scanner.nextInt();
            for (int i = 0; i < N; ++i) {
                int 번호 = scanner.nextInt();
                int 방향 = scanner.nextInt();
                회전시작(번호 - 1, 방향);
            }
            System.out.println(점수());
        }
    }
}