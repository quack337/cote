package baekjoon.b10942.old;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    static int[] A;

    static int isPalindrom(int from, int to) {
        if (from >= to) return 1;
        if (A[from] != A[to]) return 0;
        return isPalindrom(from + 1, to - 1);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        A = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(reader.readLine());
        var builder = new StringBuilder();
        for (int i = 0; i < M; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(tokenizer.nextToken()) - 1;
            int to = Integer.parseInt(tokenizer.nextToken()) - 1;
            builder.append(isPalindrom(from, to) + "\n");
        }
        System.out.println(builder.toString());
    }

}