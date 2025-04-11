package baekjoon.b1654;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] A;

    // 파라미터로 주어진 길이로 랜선들을 잘랐을 때
    // 몇 개의 랜선을 만들 수 있는지 구한다
    static long 랜선수(long 길이) {
        long result = 0;
        for (int i : A)
            result += i / 길이; // 정수 나숫셈으로 구한다. 나머지 즉 짜투리 선은 버린다.
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int K = Integer.parseInt(tokenizer.nextToken());
        int N = Integer.parseInt(tokenizer.nextToken());
        A = new int[K];

        long sum = 0; // 랜선 길이의 합계
        for (int i = 0; i < K; ++i) {
            A[i] = Integer.parseInt(reader.readLine());
            sum += A[i];
        }
        long 최대길이 = sum / N; // 이 값이 자를 수 있는 랜선의 최대 길이이다.

        long start = 1, end = 최대길이, answer = 0;
        while (start <= end) {
            long middle = (start + end) / 2;
            long count = 랜선수(middle);
            if (count >= N) {
                start = middle + 1;
                answer = middle;
            } else
                end = middle - 1;
        }
        System.out.println(answer);
    }
}