package baekjoon.p13.p13308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

@SuppressWarnings("unchecked")
public class Main2 {
    static int N, M;
    static int[] prices;
    static ArrayList<int[]>[] edges;

    static long sol() {
        var visitPrices = new int[N];
        var costs = new long[N];
        Arrays.fill(visitPrices, 1_000_000_000);
        Arrays.fill(costs, 1_000_000_000_000_000L);
        var queue = new PriorityQueue<long[]>((a, b) -> (int)(a[2] - b[2]));
        queue.add(new long[] {0, prices[0], 0});
        while (queue.size() > 0) {
            long[] p = queue.remove();
            int node = (int)p[0], price = (int)p[1]; long cost = p[2];
            if (node == N-1) return cost;
            if (visitPrices[node] <= price && costs[node] <= cost) continue;
            if (costs[node] > cost) costs[node] = cost;
            if (visitPrices[node] > price) visitPrices[node] = price;
            for (int[] edge : edges[node]) {
                int nextNode = edge[0], length = edge[1];
                int nextPrice = Math.min(price, prices[nextNode]);
                long nextCost = cost + length * price;
                if (visitPrices[nextNode] <= nextPrice && costs[nextNode] <= nextCost) continue;
                queue.add(new long[] { nextNode, nextPrice, nextCost });
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        prices = new int[N];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            prices[i] = Integer.parseInt(tokenizer.nextToken());
        edges = new ArrayList[N];
        for (int i = 0; i < N; ++i)
            edges[i] = new ArrayList<>(2);
        for (int i = 0; i < M; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            int c = Integer.parseInt(tokenizer.nextToken());
            edges[a].add(new int[] { b, c });
            edges[b].add(new int[] { a, c });
        }
        System.out.println(sol());
    }
}