package baekjoon.b17412;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, P, START, END;
    static int[][] edge;
    static int[] parents;

    static boolean BFS() {
        Arrays.fill(parents, -1);
        var queue = new ArrayDeque<int[]>();
        queue.add(new int[] {START, -1});
        while (queue.size() > 0) {
            int[] p = queue.remove();
            int node = p[0], parent = p[1];
            if (parents[node] != -1) continue;
            parents[node] = parent;
            if (node == END) return true;
            for (int child = 0; child < N; ++child)
                if (edge[node][child] > 0 && child != parent)
                    queue.add(new int[] {child, node});
        }
        return false;
    }

    static int sol() {
        int answer = 0;
        while (BFS()) {
            ++answer;
            for (int node = END; node != START; node = parents[node]) {
                edge[parents[node]][node] = 0;
                edge[node][parents[node]] = 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        P = Integer.parseInt(tokenizer.nextToken());
        edge = new int[N][N];
        parents = new int[N];
        for (int i = 0; i < P; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            edge[a][b] = 1;
        }
        START = 0; END = 1;
        System.out.println(sol());
    }
}