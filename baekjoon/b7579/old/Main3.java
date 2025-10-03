package baekjoon.b7579.old;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
    static int N, M;
    static int[] 메모리, 비용;
    static Integer[][] DP = new Integer[100][10_000];

    static int 메모리확보최대값(int index, int 남은비용) {
        if (index == N || 남은비용 == 0) return 0;
        if (DP[index][남은비용] != null) return DP[index][남은비용];
        int 메모리1 = 0, 메모리2 = 0;
        메모리1 = 메모리확보최대값(index + 1, 남은비용);
        if (남은비용 >= 비용[index])
            메모리2 = 메모리[index] + 메모리확보최대값(index + 1, 남은비용 - 비용[index]);
        return DP[index][남은비용] = Math.max(메모리1, 메모리2);
    }

    static int solution() {
        int 최소비용 = 0, 최대비용 = 10_000;
        while (최소비용 < 최대비용) {
            int 중간비용 = (최대비용 + 최소비용) / 2;
            if (메모리확보최대값(0, 중간비용) < M)
                최소비용 = 중간비용 + 1;
            else
                최대비용 = 중간비용;
        }
        return 최대비용;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        메모리 = new int[N];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            메모리[i] = Integer.parseInt(tokenizer.nextToken());
        비용 = new int[N];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            비용[i] = Integer.parseInt(tokenizer.nextToken());
        System.out.println(solution());
    }
}