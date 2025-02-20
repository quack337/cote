package baekjoon.p01.p1854.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2o {
    static final int INDEX = 0, DISTANCE = 1;

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

    static HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
    static HashMap<Integer, ArrayList<Integer>> visited;

    static boolean isVisited(Node current) {
        var list = visited.get(current.index);
        if (list == null) visited.put(current.index, list = new ArrayList<>());
        list.add(current.distance);
        return list.size() > 1;
    }

    static ArrayList<Integer> getCycle(ArrayList<Integer> path) {
        var result = new ArrayList<Integer>();
        for (int index : path) {
            var distances = visited.get(index);
            if (distances.size() > 1) {
                for (int i = 1; i < distances.size(); ++i)
                    result.add(distances.get(i) - distances.get(0));
            }
        }
        Collections.sort(result);
        return result;
    }

    static int getK(ArrayList<Node> nodes, int K) {
        var result = new ArrayList<Integer>();
        ArrayList<Integer> cycles = null;
        for (Node node : nodes) {
            result.add(node.distance);
            cycles = getCycle(node.path);
            int N = Math.min(K, cycles.size());
            for (int i = 0; i < N; ++i)
                result.add(node.distance + cycles.get(i));
        }
        Collections.sort(result);
        //System.out.printf("%d %s %s\n", nodes.get(0).index, result, cycles);
        return result.size() < K ? -1 : result.get(K - 1);
    }

    static int 탐색(int index, int goal, int K, int limit) {
        var nodes = new ArrayList<Node>();
        var queue = new PriorityQueue<Node>((a, b) -> a.distance - b.distance);
        visited = new HashMap<Integer, ArrayList<Integer>>();
        queue.add(new Node(index, 0, null));
        while (queue.size() > 0) {
            Node current = queue.remove();
            if (current.distance > limit) continue;
            if (current.index == goal) {
                nodes.add(current);
                if (nodes.size() == K) break;
            }
            if (isVisited(current)) continue;
            if (map.get(current.index) == null) continue;
            for (int[] edge : map.get(current.index))
                queue.add(new Node(edge[INDEX], edge[DISTANCE] + current.distance, current.path));
        }
        for (int i = 1; i <= visited.size(); ++i)
            System.out.printf("%d %s\n", i, visited.get(i));
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
        for (int goal = 1; goal <= N; ++goal)
            System.out.println(탐색(1, goal, K, limit));
    }

}
