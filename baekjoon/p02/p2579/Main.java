package baekjoon.p02.p2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] 계단;
    static Integer DP[][][];
    static final int FALSE = 0, TRUE = 1;

    static int 탐색(int 인덱스, int 전계단, int 전전계단) {
        if (인덱스 >= 계단.length) return 0;
        if (DP[인덱스][전계단][전전계단] != null) return DP[인덱스][전계단][전전계단];

        // 이 계단 건너뛸 수 있으면 이 계단을 건너뛴 경우의 점수를 구함
        int 점수1 = 0;
        if (전계단 == TRUE)
            점수1 = 탐색(인덱스 + 1, FALSE, 전계단);

        // 이 계단 선택할 수 있으면,  이 계단을 선택한 경우의 점수를 구함
        int 점수2 = 0;
        if (전계단 == FALSE || 전전계단 == FALSE)
            점수2 = 계단[인덱스] + 탐색(인덱스 + 1, TRUE, 전계단);

        return DP[인덱스][전계단][전전계단] = Math.max(점수1, 점수2);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        계단 = new int[N];
        DP = new Integer[N][2][2];
        // 계단을 거꾸로 뒤집는다.
        for (int i = 계단.length - 1; i >= 0; --i)
            계단[i] = Integer.parseInt(reader.readLine());
        reader.close();
        System.out.println(계단[0] + 탐색(1, TRUE, FALSE));
    }
}
