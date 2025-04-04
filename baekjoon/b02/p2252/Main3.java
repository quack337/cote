package baekjoon.b02.p2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main3 {
    static final ArrayList<Integer> EMPTY = new ArrayList<>();
    static ArrayList<Integer>[] parents;

    static int 부모없는정점() {
        for (int i = 0; i < parents.length; ++i) {
            if (parents[i] == null) continue;
            if (parents[i].size() == 0) return i;
        }
        return -1;
    }

    static void 부모제거(Integer parent) {
        for (int i = 0; i < parents.length; ++i) {
            if (parents[i] == null) continue;
            parents[i].remove(parent);
        }
    }

    static List<Integer> topologicalSort() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < parents.length; ++i) {
            int index = 부모없는정점();
            parents[index] = null;
            result.add(index);
            부모제거(index);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        parents = new ArrayList[N];
        for (int i = 0; i < M; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            if (parents[b] == null) parents[b] = new ArrayList<Integer>(2);
            parents[b].add(a);
        }
        for (int i = 0; i < N; ++i)
            if (parents[i] == null) parents[i] = EMPTY;
        List<Integer> result = topologicalSort();
        for (int i : result)
            System.out.printf("%d ", i + 1);
        System.out.println();
    }
}