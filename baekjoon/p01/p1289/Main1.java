package baekjoon.p01.p1289;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

    static final long M = 1000000007;

    static class Link {
        int node, weight;

        public Link(int index, int weight) {
            this.node = index;
            this.weight = weight;
        }
    }

    static List<Link>[] A;
    static long treeWeight = 0;

    static long multiply(long[] a) {
        long r = 0;
        for (int i = 0; i < a.length - 1; ++i)
            for (int j = i + 1; j < a.length; ++j)
                r = (r + a[i] * a[j]) % M;
        return r;
    }

    static long add(long[] a) {
        long r = 0;
        for (long i : a) r = (r + i) % M;
        return r;
    }

    static long DFS(int node, int parent) {
        List<Link> links = A[node];
        int linkCount = links.size();
        if (linkCount == 1 && links.get(0).node == parent) return 0;
        long[] values = new long[linkCount];
        long sum = 0;
        long square = 0;
        for (int i = 0; i < linkCount; ++i) {
            Link link = links.get(i);
            if (link.node == parent) continue;
            sum += values[i] = (DFS(link.node, node) * link.weight + link.weight) % M;
            square += values[i] * values[i];
        }
        treeWeight = (treeWeight + sum) % M;
        treeWeight = (treeWeight + multiply(values)) % M;
        System.out.printf("%d %d\n", multiply(values), (sum * sum - square) / 2);
        return sum % M;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            A = new List[N];
            for (int i = 0; i < N-1; ++i) {
                int node1 = scanner.nextInt() - 1;
                int node2 = scanner.nextInt() - 1;
                short weight = scanner.nextShort();
                if (A[node1] == null) A[node1] = new ArrayList<>();
                if (A[node2] == null) A[node2] = new ArrayList<>();
                A[node1].add(new Link(node2, weight));
                A[node2].add(new Link(node1, weight));
            }
            DFS(0, -1);
            System.out.println(treeWeight % M);
        }
    }
}
