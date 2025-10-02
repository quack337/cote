package baekjoon.b15681.old;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] A;
    static int[] result;

    static int DFS(int index, int parent) {
        int sum = 0;
        for (int child : A[index])
            if (child != parent)
                sum += DFS(child, index);
        return result[index] = sum + 1;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int R = Integer.parseInt(tokenizer.nextToken()) - 1;
        int Q = Integer.parseInt(tokenizer.nextToken());
        A = new ArrayList[N];
        for (int i = 0; i < N; ++i)
            A[i] = new ArrayList<Integer>();
        for (int i = 0; i < N-1; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            A[a].add(b);
            A[b].add(a);
        }
        result = new int[N];
        DFS(R, -1);
        for (int i = 0; i < Q; ++i) {
            int a = Integer.parseInt(reader.readLine()) - 1;
            System.out.println(result[a]);
        }
    }
}