package baekjoon.p06.p6086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2 {
    static int N;
    static int[][] pipe;
    static int[] count;
    static int[] depth;
    static int answer = 0;

    static int chToIndex(char c) {
        return ('A' <= c && c <= 'Z') ? c - 'A' : c - 'a' + 26;
    }

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

    static boolean DFS1(int node, int parent) {
        boolean result = false;
        for (int child = 0; child < 52; ++child)
            if (pipe[node][child] > 0 && depth[child] > depth[node])
                if (DFS1(child, node)) result = true;

        if (node == 0 || node == 25) return result;

        if (count[node] == 1) {
            pipe[node][parent] = pipe[parent][node] = 0;
            --count[parent];
            --count[node];
            return true;
        }
        if (count[node] == 2) {
            for(int child = 0; child < 52; ++child)
                if (pipe[node][child] > 0 && child != parent) {
                    if (pipe[parent][child] > 0) { --count[parent]; --count[child]; } // 병합
                    var temp = Math.min(pipe[parent][node], pipe[node][child]);
                    pipe[parent][child] += temp;
                    pipe[child][parent] += temp;
                    pipe[parent][node] = pipe[node][parent] = pipe[node][child] = pipe[child][node] = 0;
                    count[node] = 0;
                    return true;
                }
        }
        return result;
    }

/*
5
A B 3
A C 5
B C 1
B Z 5
C Z 3
답 7

이 예제를 해결하기 위한 로직을 추가함.
DFS2를 호출하기 전에 BFS를 다시 호출해서 depth를 다시 계산한다
*/
    static int DFS2(int node, int parent, int flowIn) { // flowIn: 흘러 들어온 물
        if (node == 25) { // 목적지에 도착한 물
            answer += flowIn;
            flowIn = 0; // 넘쳐 나가는 물은 없다
        }
        else {
            // 깊은 곳으로 먼저 흐른다
            var queue = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);
            for(int child = 0; child < 52; ++child)
                // 위로 흘러 올라가지는 않는다. *** 아마 이 문제에만 해당되는 조건일 듯 ***
                if (pipe[node][child] > 0 && depth[child] >= depth[node])
                    queue.add(new int[] {child, depth[child]});
            // 흘러 나갈 파이프 각각에 대해서
            while (queue.size() > 0) {
                int[] p = queue.remove();
                int child = p[0];
                // 이 파이프로 흘러나갈 수 있는 물의 양
                int flowOut = Math.min(flowIn, pipe[node][child]);

                pipe[node][child] -= flowOut; // 남은 파이프 용량이 줄어든다
                pipe[child][node] -= flowOut; // 남은 파이프 용량이 줄어든다
                flowIn -= flowOut; // 흘러 나가고 남은 물
                flowIn += DFS2(child, node, flowOut); // 넘쳐서 돌아온 물을 다시 flowIn에 더한다
                if (flowIn == 0) break;
            }
        }
        return flowIn;         // 흘러나가지 못하고 남은 물 리턴
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
            if (a == b) continue;
            int c = Integer.parseInt(tokenizer.nextToken());
            if (pipe[a][b] == 0) { ++count[a]; ++count[b]; }
            pipe[a][b] += c;
            pipe[b][a] += c;
        }
        BFS();
        while (DFS1(0, -1))
            ;
        Arrays.fill(depth, 0);
        BFS();
        //print();
        DFS2(0, -1, 1_000_000_000);
        System.out.println(answer);
    }

    static void print() {
        System.out.println(Arrays.toString(count));
        for (int a = 0; a < 52; ++a)
            for (int b = 0; b < 52; ++b)
                if (pipe[a][b] > 0)
                    System.out.printf("%c %c %d\n", a > 25 ? a + 'a' : a + 'A', b > 25 ? b + 'a' : b + 'A', pipe[a][b]);
    }
}