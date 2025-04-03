package baekjoon.p10.p10266;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] kmpPattern(int[] A) {
        int[] p = new int[A.length];
        int J = 0;
        for (int i = 1; i < A.length; ++i) {
            while (J > 0 && A[i] != A[J])
                J = p[J - 1];
            if (A[i] == A[J]) {
                ++J;
                p[i] = J;
            }
        }
        return p;
    }

    static boolean kmp(int[] T, int[] P) {
        int[] table = kmpPattern(P);
        int J = 0;
        for (int i = 0; i < T.length; ++i) {
            while (J > 0 && T[i] != P[J])
                J = table[J - 1];
            if (T[i] == P[J]) {
                ++J;
                if (J == P.length) return true;
            }
        }
        return false;
    }


    static int[] getNumbers(BufferedReader reader, int N) throws IOException {
        int[] 바늘 = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            바늘[i] = Integer.parseInt(tokenizer.nextToken());
        Arrays.sort(바늘); // 정렬한다
        int[] 각도차이 = new int[N];
        for (int i = 0; i < N; ++i) { // 앞 바늘과 각도차이를 구한다
            int 각도1 = 바늘[i];
            int 각도2 = i > 0 ? 바늘[i-1] : 바늘[바늘.length-1] - 360000;
            각도차이[i] = 각도1 - 각도2;
        }
        return 각도차이;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] 바늘1 = getNumbers(reader, N);
        int[] 바늘2 = getNumbers(reader, N);
        int[] 바늘1두배 = new int[N * 2]; // 배열1 두배 확장
        System.arraycopy(바늘1, 0, 바늘1두배, 0, N);
        System.arraycopy(바늘1, 0, 바늘1두배, N, N);
        System.out.println(kmp(바늘1두배, 바늘2) ? "possible" : "impossible");
    }
}