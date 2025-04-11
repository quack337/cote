package baekjoon.b10451;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

    static List<Integer>[] 링크;
    static boolean[] 방문한노드;

    static boolean DFS(int node) {
        if (방문한노드[node]) return true;
        방문한노드[node] = true;
        if (링크[node] == null) return false;
        for (int c : 링크[node])
            if (DFS(c)) return true;
        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int T = scanner.nextInt();
            for (int t = 0; t < T; ++t) {
                int N = scanner.nextInt();
                링크 = new ArrayList[N];
                방문한노드 = new boolean[N];
                for (int a = 0; a < N; ++a) {
                    int b = scanner.nextInt() - 1;
                    if (링크[a] == null) 링크[a] = new ArrayList<>();
                    링크[a].add(b);
                }
                int 사이클수 = 0;
                for (int i = 0; i < N; ++i) {
                    if (방문한노드[i]) continue;
                    if (DFS(i)) ++사이클수;
                }
                System.out.println(사이클수);
            }
        }
    }
}