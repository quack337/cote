package baekjoon.b2798;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] A;
    static int N, M;
    static int max = 0;

    static void solution(int index, int count, int sum) {
        if (count == 0) {
            if (sum <= M && sum > max)
                max = sum;
            return;
        }
        if (A.length - index > count)
            solution(index + 1, count, sum);
        solution(index + 1, count - 1, sum + A[index]);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        A = new int[N];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());
        solution(0, 3, 0);
        System.out.println(max);
    }
}