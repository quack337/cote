package baekjoon.p02.p2343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 오답
public class Main {

    static int N, M;
    static int[] A;

    static int 디스크수(int 크기) {
        int 디스크수 = 1, 빈공간 = 크기;
        for (int i = 0; i < N; ++i) {
            if (빈공간 < A[i]) {
                ++디스크수;
                빈공간 = 크기;
            }
            빈공간 -= A[i];
        }
        return 디스크수;
    }

    static int 이진탐색(int 최소크기, int 최대크기) {
        if (최소크기 >= 최대크기) return 최소크기;
        int 중간크기 = (최소크기 + 최대크기) / 2;
        int 수 = 디스크수(중간크기);
        if (수 > M) return 이진탐색(중간크기 + 1, 최대크기);
        else return 이진탐색(최소크기, 중간크기);
    }

    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        A = new int[N];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());
        System.out.println(이진탐색(1, 100_000 * 10_000));
    }
}
