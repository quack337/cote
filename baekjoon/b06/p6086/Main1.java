package baekjoon.b06.p6086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/*
문제에서는 파이프 한 개로 병합 가능한 예제만 주어진다고 해서 그렇게 풀었는데,
게시판에 누군가 병합이 안되는 데이터를 추가해 달라고 했다.
5
A B 3
A C 5
B C 1
B Z 5
C Z 3
답 7
*/

public class Main1 {
    static int N;
    static int[][] pipe;
    static int[] count;
    static int[] depth;

    static int chToIndex(char c) {
        return ('A' <= c && c <= 'Z') ? c - 'A' : c - 'a' + 26;
    }

    // 각 노드의 depth를 계산한다
    static void BFS() {
        var queue = new ArrayDeque<int[]>();
        queue.add(new int[] {0,1});
        while (queue.size() > 0) {
            int[] p = queue.remove();
            int node = p[0], distance = p[1];
            if (depth[node] > 0) continue;
            depth[node] = distance;
            for (int child = 0; child < 52; ++child)
                if (pipe[node][child] > 0 && depth[child] == 0)
                    queue.add(new int[] {child, distance+1});
        }
    }

    // 파이프를 병합한다
    // 리턴 값: 병합된 파이프가 있는가?
    static boolean DFS(int node, int parent) {
        boolean result = false;
        for (int child = 0; child < 52; ++child)
            if (pipe[node][child] > 0 && depth[child] > depth[node])
                if (DFS(child, node)) result = true;

        // 출발 노드, 목적지 노드는 제거되지 않는다.
        if (node == 0 || node == 25) return result;

        if (count[node] == 1) { // 끝이 막힌 파이프 제거
            pipe[node][parent] = pipe[parent][node] = 0;
            --count[parent];
            --count[node];
            return true;
        }
        if (count[node] == 2) { // 직렬 파이프 병합
            for(int child = 0; child < 52; ++child)
                if (pipe[node][child] > 0 && child != parent) {

                    // 직렬 파이프 두 개가 한 개로 병합될 때는, 카운트가 달라지지 않는다.
                    // parent -> node 였던 것이 사라지고 parent -> child가 추가된 것이니까
                    // 그런데 parent -> child가 이미 있었다면, parent -> child가 추가되지 않고 용량만 커지니까
                    // 카운트가 1씩 감소한다
                    if (pipe[parent][child] > 0) { --count[parent]; --count[child]; } // 병합

                    // 직렬 병합의 경우, 최소 파이프 값으로 조정됨.
                    var temp = Math.min(pipe[parent][node], pipe[node][child]);
                    pipe[parent][child] += temp;
                    pipe[child][parent] += temp;

                    // 사라지는 파이프
                    pipe[parent][node] = pipe[node][parent] = pipe[node][child] = pipe[child][node] = 0;
                    count[node] = 0;
                    return true;
                }
        }
        return result;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        pipe = new int[52][52];
        count = new int[52];
        depth = new int[52];
        for (int i = 0; i < N; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = chToIndex(tokenizer.nextToken().charAt(0));
            int b = chToIndex(tokenizer.nextToken().charAt(0));
            int c = Integer.parseInt(tokenizer.nextToken());
            if (pipe[a][b] == 0) { ++count[a]; ++count[b]; }
            pipe[a][b] += c;
            pipe[b][a] += c;
        }
        BFS();
        while (DFS(0, -1))
            ;
        System.out.println(pipe[0][25]);
    }
}