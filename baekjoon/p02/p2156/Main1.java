package baekjoon.p02.p2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    static int[] 포도주잔;

    static int 탐색(int 인덱스, boolean 전잔, boolean 전전잔) {
        if (인덱스 == 포도주잔.length) return 0; // 더 이상 잔이 없음
        int 합계1 = 0, 합계2 = 0;
        if (전잔 == false || 전전잔 == false) // 전 잔이나, 전전 잔을 마시지 않았다면, 이 잔을 마실 수 있다.
            합계1 = 포도주잔[인덱스] + 탐색(인덱스 + 1, true, 전잔); // 이 잔을 마신 경우의 합계를 구함
        합계2 = 탐색(인덱스 + 1, false, 전잔); // 이 잔을 마시지 않을 경우의 합계를 구함
        return Math.max(합계1, 합계2); // 큰 값을 리턴하기
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        포도주잔 = new int[N];
        for (int i = 0; i < 포도주잔.length; ++i)
            포도주잔[i] = Integer.parseInt(reader.readLine());
        reader.close();
        System.out.println(탐색(0, false, false));
    }
}