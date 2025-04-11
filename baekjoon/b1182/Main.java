package baekjoon.b1182;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] A;

static int 경우의수(int index, int count, int sum) {
    if (index == A.length)
        return (sum == S && count > 0) ? 1 : 0;
    int r1 = 경우의수(index + 1, count, sum);
    int r2 = 경우의수(index + 1, count + 1, sum + A[index]);
    return r1 + r2;
}

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        S = Integer.parseInt(tokenizer.nextToken());
        A = new int[N];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());
        System.out.println(경우의수(0, 0, 0));
    }
}