package baekjoon.p03.p3665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static HashSet<Integer>[] parents;

    static int 부모없는정점수() {
        int count = 0;
        for (int i = 0; i < parents.length; ++i) {
            if (parents[i] == null) continue;
            if (parents[i].size() == 0) ++count;
        }
        return count;
    }

    static int 부모없는정점() {
        for (int i = 0; i < parents.length; ++i) {
            if (parents[i] == null) continue;
            if (parents[i].size() == 0) return i;
        }
        return -1;
    }

    static void 부모제거(int parent) {
        for (int i = 0; i < parents.length; ++i) {
            if (parents[i] == null) continue;
            parents[i].remove(parent);
        }
    }

    static List<Integer> topologicalSort() throws Exception {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < parents.length; ++i) {
            int count = 부모없는정점수();
            if (count != 1) throw new Exception(String.valueOf(count));
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
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; ++t) {
            int N = Integer.parseInt(reader.readLine());
            parents = new HashSet[N];
            for (int i = 0; i < N; ++i)
                parents[i] = new HashSet<Integer>();
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < N; ++i) {
                int a = Integer.parseInt(tokenizer.nextToken()) - 1;
                parents[a].addAll(temp);
                temp.add(a);
            }
            int M = Integer.parseInt(reader.readLine());
            for (int i = 0; i < M; ++i) {
                tokenizer = new StringTokenizer(reader.readLine());
                int a = Integer.parseInt(tokenizer.nextToken()) - 1;
                int b = Integer.parseInt(tokenizer.nextToken()) - 1;
                if (parents[a].contains(b)) parents[a].remove(b); else parents[a].add(b);
                if (parents[b].contains(a)) parents[b].remove(a); else parents[b].add(a);
            }
            try {
                List<Integer> result = topologicalSort();
                for (int i : result)
                    System.out.printf("%d ", i + 1);
                System.out.println();
            } catch (Exception e) {
                if (e.getMessage().equals("0"))
                    System.out.println("IMPOSSIBLE");
                else
                    System.out.println("?");
            }
        }
    }
}