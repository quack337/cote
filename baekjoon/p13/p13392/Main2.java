package baekjoon.p13.p13392;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    static int N;
    static int[] 시작, 목표;
    static Integer[][] DP;

    static int[] getNumber(BufferedReader reader) throws IOException {
        String s = reader.readLine();
        int[] a = new int[N];
        for (int i = 0; i < N; ++i)
            a[i] = s.charAt(i) - '0';
        return a;
    }

    static int sol(int index, int 좌로돌아감) {
        if (index == N) return 0;
        if (DP[index][좌로돌아감] != null) return DP[index][좌로돌아감];
        int answer = Integer.MAX_VALUE;
        int ch = (시작[index] + 좌로돌아감) % 10;
        int 차이 = 목표[index] - ch;
        if (차이 >= 0) {
            int 좌회전 = 차이, 우회전 = 10 - 차이;
            answer = Math.min(answer, 좌회전 + sol(index + 1, (좌로돌아감 + 좌회전) % 10));
            answer = Math.min(answer, 우회전 + sol(index + 1, 좌로돌아감));
        } else {
            int 좌회전 = 10 + 차이, 우회전 = -차이;
            answer = Math.min(answer, 좌회전 + sol(index + 1, (좌로돌아감 + 좌회전) % 10));
            answer = Math.min(answer, 우회전 + sol(index + 1, 좌로돌아감));
        }
        return DP[index][좌로돌아감] = answer;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        DP = new Integer[N][10];
        시작 = getNumber(reader);
        목표 = getNumber(reader);
        int answer = sol(0, 0);
        System.out.println(answer);
    }

}
