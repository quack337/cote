package baekjoon.p02.p2367;
/*
package baekjoon.p02.p2367;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    static final int 시작 = 0, 종료 = 1, 사람번호 = 2;
    static int 음식번호, 노드수, 사람수, 음식수, 인당최대접시;
    static Node[] nodes;
    static Pipe[] pipes;
    static Pipe[] upPipes;

    static class Node {
        int begin, length;
        Node(int begin, int length) { this.begin = begin; this.length = length; }
    }

    static class Pipe {
        int node1, node2, capacity;
        Pipe(int n1, int n2, int c) { node1 = n1; node2 = n2; capacity = c; }
    }

    static boolean BFS() {
        Arrays.fill(upPipes, null);
        var queue = new ArrayDeque<int[]>();
        queue.add(new int[] {시작, -1});
        while (queue.size() > 0) {
            int[] p = queue.remove();
            int node = p[0], upPipe = p[1];
            if (upPipes[node] != null) continue;
            upPipes[node] = pipes[upPipe];
            if (node == 종료) return true;
            for (int i = nodes[node].begin; i < nodes[node].length; ++i)
                if (pipes[i].capacity > 0)
                    queue.add(new int[] { pipes[i].node2, i });
        }
        return false;
    }

    static int sol() {
        int answer = 0;
        while (BFS()) {
            int flow = 1_000_000_000;
            for (int node = 종료; node != 시작; node = upPipes[node].node1)
                flow = Math.min(flow, upPipes[node].capacity);
            answer += flow;
            for (int node = 종료; node != 시작; node = parents[node]) {
                pipe[parents[node]][node] -= flow;
                pipe[node][parents[node]] += flow;
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
        nodes = new Node[노드수];
        nodes[종료] = new Node(0, 0);
        var pipeList = new ArrayList<Pipe>();
        nodes[시작] = new Node(pipeList.size(), 사람수);
        for (int i = 0; i < 사람수; ++i)
            pipeList.add(new Pipe(시작, 사람번호 + i, 인당최대접시));
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < 음식수; ++i) {
            nodes[음식번호 + i] = new Node(pipeList.size(), 1);
            pipeList.add(new Pipe(음식번호 + i, 종료, Integer.parseInt(tokenizer.nextToken())));
        }
        for (int i = 0; i < 사람수; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int 요리수 = Integer.parseInt(tokenizer.nextToken());
            nodes[사람번호 + i] = new Node(pipeList.size(), 요리수);
            for (int j = 0; j < 요리수; ++j) {
                int c = Integer.parseInt(tokenizer.nextToken()) - 1;
                pipeList.add(new Pipe(사람번호 + i, 음식번호 + c, 1));
            }
        }
        pipes = pipeList.toArray(new Pipe[0]);
        parents = new int[노드수];
        System.out.println(sol());
    }
}
*/