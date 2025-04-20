package baekjoon.b13511;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

@SuppressWarnings("unchecked")
public class Main {
    static ArrayList<int[]>[] edges;
    static int[][] 조상;
    static long[][] 거리;
    static int[] 깊이;
    static int N, L;

    static void 부모찾기DFS(int node, int parent, int weight, int depth) {
        if (조상[node][0] > 0) return;
        조상[node][0] = parent;
        거리[node][0] = weight;
        깊이[node] = depth;
        for (var edge : edges[node])
            if (edge[0] != parent)
                부모찾기DFS(edge[0], node, edge[1], depth + 1); // stack overflow ???
    }

    static void 조상찾기_점화식() {
        for (int i = 1; i <= L; ++i)
            for (int node = 1; node <= N; ++node) {
                var parent1 = 조상[node][i - 1];
                var parent2 = 조상[parent1][i - 1];
                조상[node][i] = parent2;
                거리[node][i] = 거리[node][i - 1] + 거리[parent1][i - 1];
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

    static long 조상까지_거리(int ancestor, int node) {
        long distance = 0;
        while (node !=  ancestor) {
            int i = (int)(Math.log(깊이[node] - 깊이[ancestor]) / Math.log(2));
            distance += 거리[node][i];
            node = 조상[node][i];
        }
        return distance;
    }

    static int n번째조상(int node, int n) {
        while (n > 0) {
            int i = (int)(Math.log(n) / Math.log(2));
            n = n - (1 << i);
            node = 조상[node][i];
        }
        return node;
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
        거리 = new long[N + 1][L + 1];
        깊이 = new int[N + 1];
        부모찾기DFS(1, 0, 0, 0);
        조상찾기_점화식();

        int K = Integer.parseInt(reader.readLine());
        for (int i = 0; i < K; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int q = Integer.parseInt(tokenizer.nextToken());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int ancestor = 공통조상(a, b);
            if (q == 1) {
                long distance = 조상까지_거리(ancestor, a) + 조상까지_거리(ancestor, b);
                writer.write(distance + "\n");
            } else {
                int k = Integer.parseInt(tokenizer.nextToken());
                int node;
                int depth1 = 깊이[a] - 깊이[ancestor];
                int depth2 = 깊이[b] - 깊이[ancestor];
                if (k <= depth1) node = n번째조상(a, k - 1);
                else node = n번째조상(b, depth2 - k + depth1 + 1);
                writer.write(node + "\n");
            }
        }
        reader.close(); writer.close();
    }
}

/*
예제
11
1 2 1
1 3 2
2 4 3
2 5 4
3 6 5
3 7 6
4 8 7
5 9 8
6 10 9
7 11 10
18
1 8 11
2 8 11 1
2 8 11 2
2 8 11 3
2 8 11 4
2 8 11 5
2 8 11 6
2 8 11 7
1 8 9
2 8 9 1
2 8 9 2
2 8 9 3
2 8 9 4
2 8 9 5
1 4 5
2 4 5 1
2 4 5 2
2 4 5 3


출력
29
8
4
2
1
3
7
11
22
8
4
2
5
9
7
4
2
5

*/

/*
3
1 2 0
1 3 0
4
1 2 3
2 2 3 1
2 2 3 2
2 2 3 3

 */