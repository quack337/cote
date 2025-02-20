package net.skhu.codility.genomicRangeQuery;

import java.util.Arrays;

public class Solution2 {

    public static int[] solution(String S, int[] P, int[] Q) {
        int[] result = new int[P.length];
        int[] countA = new int[S.length()];
        int[] countC = new int[S.length()];
        int[] countG = new int[S.length()];
        int[] countT = new int[S.length()];

        // 0 에서 i 위치까지 A,C,G,T 의 갯수(count) 구하기
        int a = 0, c = 0, g = 0, t = 0;
        for (int i = 0; i < S.length(); ++i) {
            switch (S.charAt(i)) {
            case 'A': ++a; break;
            case 'C': ++c; break;
            case 'G': ++g; break;
            case 'T': ++t; break;
            }
            countA[i] = a;
            countC[i] = c;
            countG[i] = g;
            countT[i] = t;
        }

        for (int i = 0; i < P.length; ++i) {
            int from = P[i];
            int to = Q[i];

            // 0 ~ from-1 구간의 A 갯수보다, // 0 ~ to 구간의  A 갯수가 크다면
            // from ~ to 구간에 A가 있다는 뜻
            if (countA[to] - (from>0 ? countA[from-1] : 0) > 0)
                result[i] = 1;
            else if (countC[to] - (from>0 ? countC[from-1] : 0) > 0)
                result[i] = 2;
            else if (countG[to] - (from>0 ? countG[from-1] : 0) > 0)
                result[i] = 3;
            else
                result[i] = 4;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};

        int[] temp = solution(s, P, Q);
        System.out.println(Arrays.toString(temp));
    }
}
