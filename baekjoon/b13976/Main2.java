package baekjoon.b13976;
import java.util.Scanner;

public class Main2 {
    static int N;
    static Integer[][] DP;
    static final int 빈칸1 = 0, 빈칸3 = 1, 빈칸12 = 2, 빈칸23 = 3, 빈칸123 = 4;
    static final int 번호 = 0, 전제조건 = 1, 전진 = 2, 적용후빈칸 = 3;
    static int[][] patterns = new int[][] {
        new int[] { 0, 빈칸123, 2, 빈칸123 },
        new int[] { 1, 빈칸123, 2, 빈칸123 },
        new int[] { 2, 빈칸123, 2, 빈칸123 },
        new int[] { 3, 빈칸123, 1, 빈칸23 },
        new int[] { 4, 빈칸23, 2, 빈칸23 },
        new int[] { 5, 빈칸23, 3, 빈칸123 },
        new int[] { 6, 빈칸123, 1, 빈칸12 },
        new int[] { 7, 빈칸12, 2, 빈칸12 },
        new int[] { 8, 빈칸12, 3, 빈칸123 }
    };

    static int sol(int index, int 빈칸) {
        if (index == N)
            return 빈칸 == 빈칸123 ? 1 : 0;
        if (index > N)
            return 0;
        if (DP[index][빈칸] != null) return DP[index][빈칸];
        int result = 0;
        for (int[] pattern : patterns)
            if (pattern[전제조건] == 빈칸)
                result += sol(index + pattern[전진], pattern[적용후빈칸]);
        return DP[index][빈칸] = result;
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        N = scanner.nextInt();
        DP = new Integer[N][9];
        int answer = sol(0, 빈칸123);
        System.out.println(answer);
    }
}