package baekjoon.b05.p5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {

    static int N, M;
    static char[] S;
    static int 현재상태;
    static int 길이;

    static void IOI끝() {
        System.out.println(길이);
        길이 = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        M = Integer.parseInt(reader.readLine());
        S = reader.readLine().toCharArray();

        final int Ia = 1, Oa = 2, Ib = 3, Ob = 4;
        현재상태 = (S[0] == 'I') ? Ia : Oa;
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
                    IOI끝();
                }
                break;
            case Ib:
                if (S[i] == 'O')
                    현재상태 = Ob;
                else {
                    현재상태 = Ia;
                    IOI끝();
                }
                break;
            }
        }
    }

}