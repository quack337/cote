package baekjoon.b6086;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3 {
    static int N, START, END;
    static int[][] pipe;
    static int[] parents;

    static int chToIndex(char c) {
        return ('A' <= c && c <= 'Z') ? c - 'A' : c - 'a' + 26;
    }

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
            for (int child = 0; child < pipe.length; ++child)
                if (pipe[node][child] > 0 && child != parent)
                    queue.add(new int[] {child, node});
        }
        return false;
    }

    static int sol() {
        int answer = 0;
        while (BFS()) {
            int flow = 1_000_000_000;
            for (int node = END; node != START; node = parents[node])
                flow = Math.min(flow, pipe[parents[node]][node]);
            answer += flow;
            for (int node = END; node != START; node = parents[node]) {
                pipe[parents[node]][node] -= flow;
                pipe[node][parents[node]] += flow;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        pipe = new int[52][52];
        parents = new int[52];
        for (int i = 0; i < N; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = chToIndex(tokenizer.nextToken().charAt(0));
            int b = chToIndex(tokenizer.nextToken().charAt(0));
            int c = Integer.parseInt(tokenizer.nextToken());
            pipe[a][b] = pipe[b][a] += c;
        }
        START = 0; END = 25;
        System.out.println(sol());
    }
}