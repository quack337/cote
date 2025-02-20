package baekjoon.p02.p2367;
/*
 package baekjoon.p02.p2367;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main3 {
    static int 시작 = 0, 종료 = 1, 사람번호 = 2, 음식번호, 노드수, 사람수, 음식수, 인당최대접시;
    static HashMap<Integer, Integer> pipeMap = new HashMap<>();
    static int[] parents;

    static void pipeSet(int node1, int node2, int capacity) {
        pipeMap.put(node1 * 10000 + node2, capacity);
    }

    static void pipeAdd(int node1, int node2, int capacity) {
        pipeMap.merge(node1 * 10000 + node2, capacity, Integer::sum);
    }

    static int pipeGet(int node1, int node2) {
        return pipeMap.get(node1 * 10000 + node2);
    }

    static boolean BFS() {
        Arrays.fill(parents, -1);
        var queue = new ArrayDeque<int[]>();
        queue.add(new int[] {시작, -1});
        while (queue.size() > 0) {
            int[] p = queue.remove();
            int node = p[0], parent = p[1];
            if (parents[node] != -1) continue;
            parents[node] = parent;
            if (node == 종료) return true;
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
            for (int node = 종료; node != 시작; node = parents[node])
                flow = Math.min(flow, pipeGet(parents[node], node));
            answer += flow;
            for (int node = 종료; node != 시작; node = parents[node]) {
                pipeAdd(parents[node], node, -flow);
                pipeAdd(node, parents[node], +flow);
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        사람수 = Integer.parseInt(tokenizer.nextToken());
        인당최대접시 = Integer.parseInt(tokenizer.nextToken());
        음식수 = Integer.parseInt(tokenizer.nextToken());
        노드수 = 2 + 사람수 + 음식수;
        음식번호 = 2 + 사람수;
        for (int i = 0; i < 사람수; ++i)
            pipeSet(시작, 사람번호 + i, 인당최대접시);
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < 음식수; ++i)
            pipeSet(음식번호 + i, 종료, Integer.parseInt(tokenizer.nextToken()));
        for (int i = 0; i < 사람수; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int 요리수 = Integer.parseInt(tokenizer.nextToken());
            for (int j = 0; j < 요리수; ++j) {
                int c = Integer.parseInt(tokenizer.nextToken()) - 1;
                pipeSet(사람번호 + i, 음식번호 + c, 1);
            }
        }
        parents = new int[노드수];
        System.out.println(sol());
    }
}
*/