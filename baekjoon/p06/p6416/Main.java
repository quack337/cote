package baekjoon.p06.p6416;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static Map<Integer, List<Integer>> map = new HashMap<>();
    static Set<Integer> set = new HashSet<>();
    static int caseNo = 1;

    static int findRoot() {
        var set2 = new HashSet<Integer>(map.keySet());
        set2.removeAll(set);
        if (set2.size() != 1) return -1;
        return set2.iterator().next();
    }

    static int DFS(int node, HashSet<Integer> visited) {
        int count = 1;
        if (visited.contains(node)) return Integer.MIN_VALUE;
        visited.add(node);
        if (map.containsKey(node))
            for (int child : map.get(node))
                count += DFS(child, visited);
        return count;
    }

    static boolean isTree() {
        if (map.size() == 0) return true;
        int root = findRoot();
        if (root == -1) return false;
        int count = DFS(root, new HashSet<Integer>());
        return count == set.size() + 1;
    }

    static void printResult() {
        if (isTree())
            System.out.printf("Case %d is a tree.\n", caseNo);
        else
            System.out.printf("Case %d is not a tree.\n", caseNo);
        map.clear();
        set.clear();
        ++caseNo;
    }

    public static void main(String[] args) throws IOException {
        try (Scanner scan = new Scanner(System.in)) {
            while (true) {
                int a = scan.nextInt();
                int b = scan.nextInt();

                if (a == -1 && b == -1) return;
                else if (a == 0 && b == 0) printResult();
                else {
                    if (map.containsKey(a) == false)
                        map.put(a, new ArrayList<Integer>());
                    map.get(a).add(b);
                    set.add(b);
                }
            }
        }
    }
}