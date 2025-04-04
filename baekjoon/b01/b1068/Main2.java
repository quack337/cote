package baekjoon.b01.b1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {
    static List<Integer>[] children;
    static int X;

    static int DFS(int index) {
        if (index == X) return 0;
        if (children[index].size() == 0) return 1;
        int result = 0;
        for (int child : children[index])
            result += DFS(child);
        return result;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        children = new ArrayList[N];
        for (int i = 0; i < N; ++i)
            children[i] = new ArrayList<Integer>();
        List<Integer> roots = new ArrayList<>();;
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i) {
            int parent = Integer.parseInt(tokenizer.nextToken());
            if (parent == -1) roots.add(i);
            else children[parent].add(i);
        }
        X = Integer.parseInt(reader.readLine());
        int answer = 0;
        for (int root : roots)
            answer += DFS(root);
        System.out.println(answer);
    }
}