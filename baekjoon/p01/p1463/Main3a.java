package baekjoon.p01.p1463;

public class Main3a {

    static int[] DP;

    static int solution1(int x) {
        if (x == 1) return 0;
        if (DP[x] > 0) return DP[x];
        int r2 = Integer.MAX_VALUE, r3  = Integer.MAX_VALUE;
        int r1 = 1 + solution1(x - 1);
        if (x % 3 == 0) r3 = 1 + solution1(x / 3);
        if (x % 2 == 0) r2 = 1 + solution1(x / 2);
        return DP[x] = Math.min(r1, Math.min(r2, r3));
    }

    static int solution2(int X) {
        int[] a = new int[Math.max(4, X + 1)]; // 배열의 최소크기 4, 배열의 마지막 인덱스 X
        a[1] = 0;
        a[2] = 1;
        a[3] = 1;
        for (int x = 4; x <= X; ++x) {
            a[x] = a[x-1] + 1; // x에서 1을 빼는 것부터 시작했을 때, 연산 횟수
            if (x % 2 == 0) a[x] = Math.min(a[x], a[x/2] + 1); // x에서 2를 나누는 것부터 시작했을 때, 연산수
            if (x % 3 == 0) a[x] = Math.min(a[x], a[x/3] + 1); // x에서 3을 나누는 것부터 시작했을 때, 연산수
        }
        return a[X];
    }

    public static void main(String[] args) {
        DP = new int[500];
        for (int i = 1; i < 500; ++i) {
            if (i % 50 == 0) System.out.println(i);
            int n1 = solution1(i);
            int n2 = solution2(i);
            if (n1 != n2) {
                System.out.printf("ERROR: %d %d %d\n", i, n1, n2);
                break;
            }
        }
        System.out.println("done");
    }
}