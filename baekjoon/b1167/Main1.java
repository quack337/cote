package baekjoon.b1167;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1 {
    static int N;
    static HashMap<Integer,Integer>[] links;

    static int[] 탐색(int start) {
        var visited = new boolean[N + 1];
        var queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        queue.add(new int[] { start, 0 });
        int[] current = null;
        while (queue.size() > 0) {
            current = queue.remove();
            int node = current[0], distance = current[1];
            if (visited[node]) continue;
            visited[node] = true;
            for (int child : links[node].keySet())
                if (visited[child] == false)
                    queue.add(new int[] { child, distance + links[node].get(child) });
        }
        return current;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        links = new HashMap[N + 1];
        for (int i = 0; i < N; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int node = Integer.parseInt(tokenizer.nextToken());
            links[node] = new HashMap<Integer,Integer>();
            while (true) {
                int 이웃정점 = Integer.parseInt(tokenizer.nextToken());
                if (이웃정점 == -1) break;
                int 거리 = Integer.parseInt(tokenizer.nextToken());
                links[node].put(이웃정점, 거리);
            }
        }
        int[] last = 탐색(1);
        last = 탐색(last[0]);
        System.out.println(last[1]);
    }
}