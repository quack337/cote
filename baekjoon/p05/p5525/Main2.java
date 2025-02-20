package baekjoon.p05.p5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    static int N, M, 길이, 답, 현재상태;
    static char[] S;

    static void IOI끝() {
        // 길이가 길이인 IOI 문자열에는 길이가 N인 IOI 문자열이
        // (길이 - N + 1) 개 들어있다.
        if (길이 >= N)
            답 += (길이 - N + 1);
        길이 = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        M = Integer.parseInt(reader.readLine());
        S = reader.readLine().toCharArray();

        final int Ia = 1, Oa = 2, Ib = 3, Ob = 4; // 상태 값들
        현재상태 = (S[0] == 'I') ? Ia : Oa; // 첫 문자로 첫 상태 계산
        길이 = 0;
        for (int i = 1; i < S.length; ++i) {
            switch (현재상태) {
            case Oa:
                if (S[i] == 'I') 현재상태 = Ia;
                break;
            case Ia:
                if (S[i] == 'O') 현재상태 = Ob;
                break;
            case Ob:
                if (S[i] == 'I') {
                    현재상태 = Ib;
                    ++길이;
                } else {
                    현재상태 = Oa;
                    IOI끝(); // 찾은 IOI 패턴에서, 부문 문자열의 수 계산
                }
                break;
            case Ib:
                if (S[i] == 'O')
                    현재상태 = Ob;
                else {
                    현재상태 = Ia;
                    IOI끝(); // 찾은 IOI 패턴에서, 부문 문자열의 수 계산
                }
                break;
            }
        }
        IOI끝(); // 찾은 IOI 패턴에서, 부문 문자열의 수 계산
        System.out.println(답);
    }

}
