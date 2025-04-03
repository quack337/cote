package baekjoon.p02.p2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    static int[] 계단;

    static int 탐색(int 인덱스, boolean 전계단, boolean 전전계단) {
        if (인덱스 >= 계단.length) return 0;

        // 이 계단 건너뛸 수 있으면 이 계단을 건너뛴 경우의 점수를 구함
        int 점수1 = 0;
        if (전계단) // 전 계단을 밟았으면 이 계단 건너뛸 수 있다.
            점수1 = 탐색(인덱스 + 1, false, 전계단);  // 인덱스+1 계단 재귀호출,
                           //이 계단은 밟지 않았으므로 false, 이제 전계단이 전전계단이 된다.

        // 이 계단 선택할 수 있으면,  이 계단을 선택한 경우의 점수를 구함
        int 점수2 = 0;
        // 전 계단이나 전전 계단을 밟지 않았다면, 이 계단을 밟을 수 있다.
        if (전계단 == false || 전전계단 == false)
            점수2 = 계단[인덱스] + 탐색(인덱스 + 1, true, 전계단);
            // 이 계단을 밟았으므로 점수를 더해야 하고,
            // 인덱스 + 1 계단 재귀호출

        return Math.max(점수1, 점수2);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        계단 = new int[N];
        // 계단을 거꾸로 뒤집는다.
        for (int i = 계단.length - 1; i >= 0; --i)
            계단[i] = Integer.parseInt(reader.readLine());
        reader.close();
        System.out.println(계단[0] + 탐색(1, true, false));
    }
}