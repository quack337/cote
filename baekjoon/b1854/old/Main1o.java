package baekjoon.b1854.old;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1o {
    static final int INDEX = 0, DISTANCE = 1;
    static HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();

    static int 탐색(int index, int goal, int K, int limit) {
        int k = 0;
        var queue = new PriorityQueue<int[]>((a, b) -> a[DISTANCE] - b[DISTANCE]);
        queue.add(new int[] {index, 0});
        while (queue.size() > 0) {
            int[] current = queue.remove();
            if (current[DISTANCE] > limit) continue;
            if (current[INDEX] == goal) {
                if (++k == K) return current[DISTANCE];
            }
            if (map.get(current[INDEX]) == null) continue;
            for (int[] edge : map.get(current[INDEX]))
                queue.add(new int[] { edge[INDEX], edge[DISTANCE] + current[DISTANCE] });
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        int limit = 0;
        for (int m = 0; m < M; ++m) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());
            limit += c;
            ArrayList<int[]> list = map.get(a);
            if (list == null) map.put(a, list = new ArrayList<int[]>());
            list.add(new int[] {b, c});
        }
        for (int goal = 1; goal <= N; ++goal)
            System.out.println(탐색(1, goal, K, limit));
    }

}