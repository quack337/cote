package baekjoon.b02.p2401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main1 {
    static char[] A;            // 전체 문자열
    static ArrayList<int[]> P;  // 붙여넣을 위치 {시작인덱스, 끝인덱스}

    static int[] kmpPattern(char[] s) {
        int[] p = new int[s.length];
        int J = 0;
        for (int i = 1; i < s.length; ++i) {
            while (J > 0 && s[i] != s[J])
                J = p[J - 1];
            if (s[i] == s[J])
                p[i] = ++J;
        }
        return p;
    }

    static void 붙여넣을위치찾기(char[] S) {
        int[] p = kmpPattern(S);
        int J = 0;
        for (int i = 0; i < A.length; ++i) {
            while (J > 0 && A[i] != S[J])
                J = p[J - 1];
            if (A[i] == S[J]) {
                ++J;
                if (J == S.length) {
                    P.add(new int[] { i - J + 1, i}); // 붙여 넣을 수 있는 위치를 기록한다
                                 // { 시작인덱스, 끝인덱스 } 기록
                    J = p[J - 1];
                }
            }
        }
    }

    // from, to 영역에 붙여 넣을 수 있는 최대 길이 찾기
    static int sol(int from, int to) {
        if (from > to) return 0; // 종료 조건
        int result = 0;
        for (int i = 0; i < P.size(); ++i) { // 붙여 넣을 수 있는 위치 각각에 대해서
            int[] p = P.get(i);
            int from2 = p[0], to2 = p[1]; // 붙여 넣을 시작 인덱스, 끝 인덱스
            if (from <= from2 && to2 <= to)
                result = Math.max(result, (to2 - from2 + 1) + sol(from, from2 - 1) + sol(to2 + 1, to));
                 // (to2 - from2 + 1) => 붙여 넣을 문자열 길이
                 //   + sol(from, from2 - 1) => 왼쪽 영역에 붙여넣을 수 있는 최대 길이 찾기
                 //   + sol(to2 + 1, to)  => 오늘쪽 영역에 붙여넣을 수 있는 최대 길이 찾기
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        A = reader.readLine().toCharArray();
        int N = Integer.parseInt(reader.readLine());
        P = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            char[] S = reader.readLine().toCharArray();
            붙여넣을위치찾기(S);
        }
        int answer = sol(0, A.length - 1);
        System.out.println(answer);
    }
}