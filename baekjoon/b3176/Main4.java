package baekjoon.b3176;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

@SuppressWarnings("unchecked")
public class Main4 {
    static ArrayList<int[]>[] edges;
    static int[][] 조상;
    static int[][] 최소;
    static int[][] 최대;
    static int[] 깊이;
    static int N, L;

    static void 부모찾기DFS(int node, int parent, int weight, int depth) {
        if (조상[node][0] > 0) return;
        조상[node][0] = parent;
        최소[node][0] = 최대[node][0] = weight;
        깊이[node] = depth;
        for (var edge : edges[node])
            if (edge[0] != parent)
                부모찾기DFS(edge[0], node, edge[1], depth + 1);
    }

    static void 조상찾기_점화식() {
        for (int i = 1; i <= L; ++i)
            for (int node = 1; node <= N; ++node) {
                var parent1 = 조상[node][i - 1];
                var parent2 = 조상[parent1][i - 1];
                조상[node][i] = parent2;
                최소[node][i] = Math.min(최소[node][i - 1], 최소[parent1][i - 1]);
                최대[node][i] = Math.max(최대[node][i - 1], 최대[parent1][i - 1]);
            }
    }

    static int 공통조상(int a, int b) {
        if (깊이[a] < 깊이[b]) return 공통조상(b, a);
        while (깊이[a] >  깊이[b])
            a = 조상[a][(int)(Math.log(깊이[a] - 깊이[b]) / Math.log(2))];
        while (a != b) {
            int i;
            for (i = 1; 조상[a][i] != 조상[b][i]; ++i)
                ;
            a = 조상[a][i - 1];
            b = 조상[b][i - 1];
        }
        return a;
    }

    static int[] 조상까지_최대최소(int ancestor, int node) {
        if (node == ancestor) return new int[] { Integer.MAX_VALUE, 0 };
        int min = 최소[node][0], max = 최대[node][0];
        while (node !=  ancestor) {
            int i = (int)(Math.log(깊이[node] - 깊이[ancestor]) / Math.log(2));
            min = Math.min(min, 최소[node][i]);
            max = Math.max(max, 최대[node][i]);
            node = 조상[node][i];
        }
        return new int[] {min, max};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(reader.readLine());
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; ++i)
            edges[i] = new ArrayList<int[]>();
        StringTokenizer tokenizer;
        for (int i = 0; i < N - 1; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());
            edges[a].add(new int[] { b, w });
            edges[b].add(new int[] { a, w });
        }
        L = (int)(Math.log(N) / Math.log(2));
        조상 = new int[N + 1][L + 1];
        최소 = new int[N + 1][L + 1];
        최대 = new int[N + 1][L + 1];
        깊이 = new int[N + 1];
        부모찾기DFS(1, 0, 0, 0);
        조상찾기_점화식();

        int K = Integer.parseInt(reader.readLine());
        for (int i = 0; i < K; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int ancestor = 공통조상(a, b);
            int[] aa = 조상까지_최대최소(ancestor, a);
            int[] bb = 조상까지_최대최소(ancestor, b);
            writer.write(Math.min(aa[0], bb[0]) + " ");
            writer.write(Math.max(aa[1], bb[1]) + "\n");
        }
        reader.close(); writer.close();
    }
}