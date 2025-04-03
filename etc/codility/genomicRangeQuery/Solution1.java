package codility.genomicrangequery;

import java.util.Arrays;

public class Solution1 {

    public static int[] solution(String S, int[] P, int[] Q) {
        for (int i = 0; i < P.length; ++i) {
            int from = P[i];
            int to = Q[i];
            int min = Integer.MAX_VALUE;
            for (int j = from; j <= to; ++j) {
                char c = S.charAt(j);
                if (c < min) min = c;
            }
            switch (min) {
            case 'A': P[i] = 1; break;
            case 'C': P[i] = 2; break;
            case 'G': P[i] = 3; break;
            case 'T': P[i] = 4; break;
            }
        }
        return P;
    }

    public static void main(String[] args) {
        String s = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};

        int[] temp = solution(s, P, Q);
        System.out.println(Arrays.toString(temp));
    }
}