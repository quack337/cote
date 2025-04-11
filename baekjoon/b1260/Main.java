package baekjoon.b1260;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static void DFS(List<Integer>[] A, int start) {
        boolean[] visited = new boolean[A.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        while (stack.size() > 0) {
            int current = stack.pop();
            if (visited[current]) continue;
            visited[current] = true;
            System.out.print(current + " ");
            A[current].sort((i1, i2) -> i2 - i1);
            for (int child : A[current])
                if (visited[child] == false)
                    stack.push(child);
        }
        System.out.println();
    }

    static void BFS(List<Integer>[] A, int start) {
        boolean[] visited = new boolean[A.length];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        while (queue.size() > 0) {
            int current = queue.remove();
            if (visited[current]) continue;
            visited[current] = true;
            System.out.print(current + " ");
            Collections.sort(A[current]);
            for (int child : A[current])
                if (visited[child] == false)
                    queue.add(child);
        }
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());    // 정점의 수
        int M = Integer.parseInt(tokenizer.nextToken());    // 간선의 수
        int V = Integer.parseInt(tokenizer.nextToken());    // 시작 정점 번호
        ArrayList<Integer>[] A = new ArrayList[N + 1];      // 이웃 정점 목록
        for (int i = 1; i <= N; ++i)
            A[i] = new ArrayList<Integer>();
        for (int i = 1; i <= M; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());  // 간선으로 연결된 정점 #1
            int b = Integer.parseInt(tokenizer.nextToken());  // 간선으로 연결된 정점 #2
            A[a].add(b);   // 이웃 정점 목록에 정점 추가
            A[b].add(a);   // 이웃 정점 목록에 정점 추가
        }
        DFS(A, V);
        BFS(A, V);
    }
}