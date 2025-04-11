package baekjoon.b1976;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[][] edge; // edge[i][j] 도시 i, j 사이에 간선이 있는가

    static void DFS(int node, boolean[] visited) {
        if (visited[node]) return;
        visited[node] = true;
        for (int neighbor = 0; neighbor < N; ++neighbor)
            if (edge[node][neighbor]) DFS(neighbor, visited);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        M = Integer.parseInt(reader.readLine());
        edge = new boolean[N][N];
        for (int r = 0; r < N; ++r) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 0; c < N; ++c)
                edge[r][c] = tokenizer.nextToken().charAt(0) == '1';
        }
        boolean[] visited = null;
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < M; ++i) {
            int city = Integer.parseInt(tokenizer.nextToken()) - 1;
            if (visited == null) { // city가 여행 계획 첫 도시이다.
                visited = new boolean[N]; // 이 도시에 연결된 도시들을
                DFS(city, visited);       // DFS로 다 찾자
            }
            else if (visited[city] == false) { // 연결안된 도시가 있다면 실패
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}