package baekjoon.p02.p2629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int[] getNumbers(BufferedReader reader) throws IOException {
        int N = Integer.parseInt(reader.readLine());
        int[] a = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            a[i] = Integer.parseInt(tokenizer.nextToken());
        return a;
    }

    static Boolean[][] DP = new Boolean[80000][30];

    static boolean DFS(int[] weights, int balance, int index) {
        if (balance == 0) return true;
        if (index >= weights.length) return false;
        if (DP[balance+20000][index] != null) return DP[balance+20000][index];
        if (DFS(weights, balance - weights[index], index + 1) ||
            DFS(weights, balance, index + 1) ||
            DFS(weights, balance + weights[index], index + 1))
                return DP[balance+20000][index] = true;
        return DP[balance+20000][index] = false;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] weights = getNumbers(reader);
        int[] beads = getNumbers(reader);
        StringBuilder builder = new StringBuilder();
        for (int bead : beads)
            builder.append(DFS(weights, bead, 0) ? "Y " : "N ");
        System.out.println(builder);
    }
}
