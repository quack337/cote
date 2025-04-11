package baekjoon.b2014;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int K = Integer.parseInt(tokenizer.nextToken());
        int N = Integer.parseInt(tokenizer.nextToken());
        TreeSet<Integer> treeSet = new TreeSet<>();
        int[] primNumbers = new int[K];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < K; ++i) {
            primNumbers[i] = Integer.parseInt(tokenizer.nextToken());
            treeSet.add(primNumbers[i]);
        }
        int value = 0, count = 0;
        while (true) {
            value = treeSet.first();
            treeSet.remove(value);
            if (++count == N) break;
            for (int i : primNumbers)
                treeSet.add(value * i);
        }
        System.out.println(value);
    }
}