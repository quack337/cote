package baekjoon.b11.p11049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1a {
    static int[][] A;
    static int N;

    // A 배열에서 start 부터 end 까지 행렬들을 전부 곱할 때
    // 곱셈횟수 최소값을 구한다.
    static int 곱셈횟수최소값(int start, int end) {
        if (start == end) return 0; // 행렬이 한 개이면 곱할 수 없다.

        int min = Integer.MAX_VALUE; // 최소 값을 찾자.
        for (int i = start; i < end; ++i) { // i 위치를 기준으로 쪼갠다.

            // start 부터 i 까지 행렬들을 전부 곱할 때 곱셈횟수 최소값
            int n1 = 곱셈횟수최소값(start, i);

            // i + 1 부터 end 까지 행렬들을 전부 곱할 때 곱셈횟수 최소값
            int n2 = 곱셈횟수최소값(i + 1, end);

            // start 부터 i 까지 행렬들을 모두 곱한 결과는 (A[start][0], A[i][1]) 크기 행렬이다.
            // i + 1 부터 end 까지 행렬들을 모두 곱한 결과는 (A[i + 1][0], A[end][1]) 크기 행렬이다.
            // 이 두 행렬을 곱할 때, 곱셈의 수는, 다음과 같다.
            int n3 = A[start][0] * A[i][1] * A[end][1];

            // i 위치를 기준으로 쪼갤 때, 곱셈의 수는 n1 + n2 + n3 이다.
            // 이 값의 최소 값을 찾아야 한다.
            min = Math.min(min, n1 + n2 + n3);
        }
        return min;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        A = new int[N][2];
        for (int i = 0; i < N; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            A[i][0] = Integer.parseInt(tokenizer.nextToken());
            A[i][1] = Integer.parseInt(tokenizer.nextToken());
        }
        System.out.println(곱셈횟수최소값(0, N-1));
    }
}