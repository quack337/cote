package baekjoon.b2957;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;

public class Main {
    static class Node {
        int value, depth;
        Node left, right;

        public Node(int value, int depth) {
            this.value = value;
            this.depth = depth;
        }
    }

    static long count;
    static Node root;
    static TreeMap<Integer, Node> map = new TreeMap<>();

    static void insert(int x) {
        Integer lp = map.floorKey(x);
        Node parentNode = null;
        if (lp != null && (parentNode = map.get(lp)).right == null) {
            Node node = new Node(x, parentNode.depth + 1);
            map.put(x, node);
            parentNode.right = node;
        } else {
            Integer rp = map.ceilingKey(x);
            parentNode = map.get(rp);
            Node node = new Node(x, parentNode.depth + 1);
            map.put(x, node);
            parentNode.left = node;
        }
        count += parentNode.depth;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(reader.readLine());
        root = new Node(Integer.parseInt(reader.readLine()), 1);
        map.put(root.value, root);
        writer.append("0\n");
        for (int i = 1; i < N; ++i) {
            int a = Integer.parseInt(reader.readLine());
            insert(a);
            writer.append(String.valueOf(count));
            writer.append('\n');
        }
        reader.close();
        writer.close();
    }
}