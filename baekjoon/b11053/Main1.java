package baekjoon.b11053;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    static int[] A;

    static int 탐색(int index, int previous) {
        if (index >= A.length) return 0;

        int count1 = 0, count2 = 0;
        if (A[index] > previous) count1 = 1 + 탐색(index + 1, A[index]);
        count2 = 탐색(index + 1, previous);
        return Math.max(count1, count2);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        A = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            A[i] = Integer.parseInt(tokenizer.nextToken());
        System.out.println(탐색(0, 0));
    }
}