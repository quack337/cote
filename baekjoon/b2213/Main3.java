package baekjoon.b2213;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

@SuppressWarnings("unchecked")
public class Main3 {
    static ArrayList<Integer>[] neighbor;
    static int[] W;
    static Integer[][] DP;
    static boolean[] 집합;

    static int sol(int node, int parent, int selected) {
        if (DP[node][selected] != null) return DP[node][selected];
        int result1 = 0, result2 = (selected == 0 ? W[node] : 0);
        for (int child : neighbor[node]) {
            if (child == parent) continue;
            result1 += sol(child, node, 0);
            if (selected == 0) result2 += sol(child, node, 1);
        }
        return DP[node][selected] = Math.max(result1, result2);
    }

    static void DFS(int node, int parent, int selected) {
        int result1 = 0, result2 = (selected == 0 ? W[node] : 0);
        for (int child : neighbor[node]) {
            if (child == parent) continue;
            result1 += DP[child][0];
            if (selected == 0) result2 += DP[child][1];
        }
        집합[node] = (result2 > result1);
        for (int child : neighbor[node])
            if (child != parent)
                DFS(child, node, 집합[node] ? 1 : 0);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        DP = new Integer[N][2];
        W = new int[N];
        집합 = new boolean[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            W[i] = Integer.parseInt(tokenizer.nextToken());
        neighbor = new ArrayList[N];
        for (int i = 0; i < N - 1; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            if (neighbor[a] == null) neighbor[a] = new ArrayList<>();
            if (neighbor[b] == null) neighbor[b] = new ArrayList<>();
            neighbor[a].add(b);
            neighbor[b].add(a);
        }
        var builder = new StringBuilder();
        builder.append(sol(0, -1, 0) + "\n");
        DFS(0, -1, 0);
        for (int i = 0; i < 집합.length; ++i)
            if (집합[i]) builder.append((i + 1) + " ");
        System.out.println(builder.toString());
    }
}