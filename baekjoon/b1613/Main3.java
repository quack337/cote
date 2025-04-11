package baekjoon.b1613;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main3 {
    static ArrayList<Integer>[] A;
    static HashSet<Integer>[] B;

    static HashSet<Integer> DFS2(int index) {
        if (B[index] == null) {
            B[index] = new HashSet<>();
            for (int child : A[index]) {
                B[index].add(child);
                B[index].addAll(DFS2(child));
            }
        }
        return B[index];
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        A = new ArrayList[N];
        for (int i = 0; i < N; ++i)
            A[i] = new ArrayList<Integer>();
        for (int k = 0; k < K; ++k) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            A[a].add(b);
        }
        B = new HashSet[N];
        for (int i = 0; i < N; ++i)
            if (B[i] == null) DFS2(i);
        int S = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();
        for (int s = 0; s < S; ++s) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            if (B[a].contains(b)) builder.append(-1).append('\n');
            else if (B[b].contains(a)) builder.append(1).append('\n');
            else builder.append(0).append('\n');
        }
        System.out.println(builder.toString());
    }
}