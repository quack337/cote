package baekjoon.b12865.old;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] W, V;
    static int[][] DP;

    static int 최대가치(int index, int 남은무게) {
        if (index >= N || 남은무게 <= 0) return 0;
        if (DP[index][남은무게] > 0) return DP[index][남은무게];
        int 가치1 = 0, 가치2 = 0;
        가치1 = 최대가치(index + 1, 남은무게); // index번 물건을 선택 안 한 경우 최대가치
        if (W[index] <= 남은무게)              // index번 물건을 선택한 경우 최대가치
            가치2 = V[index] + 최대가치(index + 1, 남은무게 - W[index]);
        return DP[index][남은무게] = Math.max(가치1, 가치2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());
        W = new int[N];
        V = new int[N];
        DP = new int[N][K+1];
        for (int i = 0; i < N; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            W[i] = Integer.parseInt(tokenizer.nextToken());
            V[i] = Integer.parseInt(tokenizer.nextToken());
        }
        System.out.println(최대가치(0, K));
    }
}