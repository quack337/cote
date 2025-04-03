package baekjoon.p13.p13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] links;

static boolean DFS(int current, HashSet<Integer> visited) {
    if (visited.size() == 5) return true;
    if (visited.contains(current)) return false;
    visited.add(current);
    for (int node : links[current])
        if (DFS(node, visited))
            return true;
    visited.remove(current);
    return false;
}

    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        links = new ArrayList[N];
        for (int i = 0; i < N; ++i)
            links[i] = new ArrayList<Integer>();
        for (int i = 0; i < M; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            links[a].add(b);
            links[b].add(a);
        }
        for (int i = 0; i < N; ++i)
            if (DFS(i, new HashSet<Integer>())) {
                System.out.println(1);
                return;
            }
        System.out.println(0);
    }

}