package baekjoon.b3665;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {

    static class Vertex {
        int id;
        HashSet<Integer> parents = new HashSet<>();

        public Vertex(int id) {
            this.id = id;
        }
    }

    static int 부모없는정점수(List<Vertex> list) {
        int count = 0;
        for (Vertex v : list)
            if (v.parents.size() == 0) ++count;
        return count;
    }

    static Vertex 부모없는정점제거(List<Vertex> list) {
        Iterator<Vertex> it = list.iterator();
        while (it.hasNext()) {
            Vertex v = it.next();
            if (v.parents.size() == 0) {
                it.remove();
                return v;
            }
        }
        return null;
    }

    static void 부모제거(List<Vertex> list, int parent) {
        for (Vertex v : list)
            v.parents.remove(parent);
    }

    static List<Vertex> topologicalSort(List<Vertex> list) throws Exception {
        List<Vertex> result = new ArrayList<>();
        while (list.size() > 0) {
            int count = 부모없는정점수(list);
            if (count != 1) throw new Exception(String.valueOf(count));
            Vertex v = 부모없는정점제거(list);
            result.add(v);
            부모제거(list, v.id);
        }
        return result;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; ++t) {
            int N = Integer.parseInt(reader.readLine());
            ArrayList<Vertex> list = new ArrayList<>();
            for (int i = 0; i < N; ++i)
                list.add(new Vertex(i));
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < N; ++i) {
                int a = Integer.parseInt(tokenizer.nextToken()) - 1;
                for (int j = 0; j < N; ++j)
                    if (j != a) list.get(i).parents.add(i);
            }
            int M = Integer.parseInt(reader.readLine());
            for (int i = 0; i < M; ++i) {
                int a = Integer.parseInt(tokenizer.nextToken()) - 1;
                int b = Integer.parseInt(tokenizer.nextToken()) - 1;
                Vertex va = list.get(a);
                Vertex vb = list.get(b);
                if (va.parents.contains(b)) va.parents.remove(b); else va.parents.add(b);
                if (vb.parents.contains(a)) vb.parents.remove(a); else vb.parents.add(a);
            }

        }


    }
}