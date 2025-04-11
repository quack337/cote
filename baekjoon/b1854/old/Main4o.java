package baekjoon.b1854.old;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main4o {
    static class Node {
        int index, distance;
        ArrayList<Integer> path = new ArrayList<>();

        public Node(int index, int distance, ArrayList<Integer> path) {
            this.index = index;
            this.distance = distance;
            if (path != null) this.path.addAll(path);
            this.path.add(index);
        }
    }

    static final int INDEX = 0, DISTANCE = 1;
    static HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
    static HashMap<Integer, ArrayList<Integer>> cycles = new HashMap<>();

    static ArrayList<Integer> 사이클탐색(int index, int K, int limit) {
        var result = new ArrayList<Integer>();
        var queue = new PriorityQueue<int[]>((a, b) -> a[DISTANCE] - b[DISTANCE]);
        queue.add(new int[] {index, 0});
        while (queue.size() > 0) {
            int[] current = queue.remove();
            if (current[DISTANCE] > limit) continue;
            if (current[INDEX] == index && current[DISTANCE] > 0) {
                result.add(current[DISTANCE]);
                if (result.size() == K) return result;
            }
            if (map.get(current[INDEX]) == null) continue;
            for (int[] edge : map.get(current[INDEX]))
                queue.add(new int[] { edge[INDEX], edge[DISTANCE] + current[DISTANCE] });
        }
        return null;
    }

    static int getK(ArrayList<Node> nodes, int K) {
        var result = new ArrayList<Integer>();
        for (Node node : nodes) {
            result.add(node.distance);
            var cycle = new ArrayList<Integer>();
            for (int index : node.path)
                if (cycles.get(index) != null)
                    cycle.addAll(cycles.get(index));
            //System.out.printf("path cycle: %s %s\n", node.path, cycle);
            Collections.sort(cycle);
            int N = Math.min(K, cycle.size());
            for (int i = 0; i < N; ++i)
                result.add(node.distance + cycle.get(i));
        }
        Collections.sort(result);
        //System.out.printf("%d %s\n", nodes.get(0).index, result);
        return result.size() < K ? -1 : result.get(K - 1);
    }

    static int 탐색(int index, int goal, int K, int limit) {
        var nodes = new ArrayList<Node>();
        var queue = new PriorityQueue<Node>((a, b) -> a.distance - b.distance);
        queue.add(new Node(index, 0, null));
        while (queue.size() > 0) {
            Node current = queue.remove();
            if (current.distance > limit) continue;
            if (current.index == goal) {
                nodes.add(current);
                if (nodes.size() == K) break;
            }
            if (map.get(current.index) == null) continue;
            for (int[] edge : map.get(current.index))
                if (current.path.contains(edge[INDEX]) == false)
                    queue.add(new Node(edge[INDEX], edge[DISTANCE] + current.distance, current.path));
        }
        return getK(nodes, K);
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
        for (int i = 1; i <= N; ++i)
            cycles.put(i, 사이클탐색(i, K, limit));
            //System.out.println(사이클탐색(i, K, limit));
        for (int goal = 1; goal <= N; ++goal)
            System.out.println(탐색(1, goal, K, limit));
    }

}