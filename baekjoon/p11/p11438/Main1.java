package baekjoon.p11.p11438;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1 {
    static int[][] DP;
    static int[] depths;
    static ArrayList<Integer>[] children;

    static void depthDFS(int x, int parent, int depth) {
        DP[x][0] = parent;
        depths[x] = depth;
        for (int child : children[x])
            if (child != parent)
                depthDFS(child, x, depth + 1);
    }

    static int sol(int a, int b) {
        while (true) {
            int diff = depths[a] - depths[b];
            if (diff > 0) {
                int diff_log = (int)(Math.log(depths[a] - depths[b]) / Math.log(2));
                a = DP[a][diff_log];
            } else if (diff < 0) {
                int temp = a;
                a = b;
                b = temp;
            } else
                break;
        }
        while (true) {
            if (a == b) return a;
            if (DP[a][0] == DP[b][0]) return DP[a][0];

            int i;
            for (i = 1; DP[a][i] != DP[b][i]; ++i)
                ;
            a = DP[a][i - 1];
            b = DP[b][i - 1];
        }
    }

    public static void main(String[] args) throws IOException  {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(reader.readLine());

        children = new ArrayList[N+1];
        for (int i = 1; i <= N; ++i)
            children[i] = new ArrayList<Integer>();
        StringTokenizer tokenizer;
        for (int i = 0; i < N - 1; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            children[a].add(b);
            children[b].add(a);
        }

        int H = (int)(Math.log(N) / Math.log(2)) + 1;
        DP = new int[N+1][H];
        depths = new int[N+1];
        depthDFS(1, 0, 1);
        children = null;

        for (int h = 1; h < H; ++h)
            for (int x = 1; x <= N; ++x) {
                int parent1 = DP[x][h - 1];
                DP[x][h] = DP[parent1][h - 1];
            }

        int M = Integer.parseInt(reader.readLine());
        for (int i = 0; i < M; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            writer.write(sol(a, b) + "\n");
        }
        reader.close();
        writer.close();
    }
}
