package baekjoon.b1967;
import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {

    static ArrayList<int[]>[] edges;

    static int[] DFS(int a, int parent) {
        int[] max = new int[] {a, 0};
        for (int[] edge : edges[a]) {
            int b = edge[0], w = edge[1];
            if (b == parent) continue;
            int[] result = DFS(b, a);
            result[1] += w;
            if (result[1] > max[1]) max = result;
        }
        return max;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        edges = new ArrayList[N];
        for (int i = 0; i < N; ++i)
            edges[i] = new ArrayList<int[]>();
        for (int i = 0; i < N - 1; ++i) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            int w = scanner.nextInt();
            edges[a].add(new int[] {b, w});
            edges[b].add(new int[] {a, w});
        }
        int[] max = DFS(0, -1);
        max = DFS(max[0], -1);
        System.out.println(max[1]);
        scanner.close();
    }
}