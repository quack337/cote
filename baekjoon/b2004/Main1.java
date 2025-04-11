package baekjoon.b2004;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {

    // n! 값의 소인수에서 factor의 갯수 구하기
    static int countFactor(int n, int factor) {
        int count = 0;
        for (int i = 2; i <= n; ++i) {
            while (i > 1 && i % factor == 0) {
                ++count;
                i /= factor;
            }
        }
        return count;
    }

    // n! 값의 소인수에서 2와 5의 갯수 구하기
    static int[] count2n5(int n) {
        int[] result = new int[2];
        result[0] = countFactor(n, 2);
        result[1] = countFactor(n, 5);
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        // nCm 분자인 n! 값의 소인수에서 2와 5의 갯수 구하기.
        int[] result1 = count2n5(N);

        // nCm 분모인 m!, (n-m)! 값의 소인수에서 2와 5의 갯수 구하기.
        int[] result2 = count2n5(M);
        int[] result3 = count2n5(N-M);

        result1[0] -= result2[0] + result3[0];
        result1[1] -= result2[1] + result3[1];
        System.out.println(Math.min(result1[0], result1[1]));
    }
}