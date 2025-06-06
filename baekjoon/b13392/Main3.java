package baekjoon.b13392;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {
    static int N;
    static int[] 시작, 목표;
    static Integer[][] DP;

    static int sol(int index, int 좌로돌아감) {
        if (index == N) return 0;
        if (DP[index][좌로돌아감] != null) return DP[index][좌로돌아감];
        int ch = (시작[index] + 좌로돌아감) % 10;
        int 차이 = 목표[index] - ch;
        int 좌회전 = (차이 >= 0) ? 차이 : 10 + 차이;
        int 우회전 = (차이 >= 0) ? 10 - 차이 : -차이;
        int r1 = 좌회전 + sol(index + 1, (좌로돌아감 + 좌회전) % 10);
        int r2 = 우회전 + sol(index + 1, 좌로돌아감);
        return DP[index][좌로돌아감] = Math.min(r1, r2);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        DP = new Integer[N][10];
        시작 = reader.readLine().chars().map(ch -> ch - '0').toArray();
        목표 = reader.readLine().chars().map(ch -> ch - '0').toArray();
        int answer = sol(0, 0);
        System.out.println(answer);
    }
}