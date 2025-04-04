package baekjoon.b09.p9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    static int[] A;
    static int N;

    static boolean DFS(int start) {
        boolean[] visited = new boolean[N];
        visited[start] = true;
        int index = A[start];
        while (true) {
            //System.out.println(index);
            if (index == start) return true;
            if (visited[index]) return false;
            visited[index] = true;
            index = A[index];
        }
    }

    static int solution() {
        int count = 0;
        for (int i = 0; i < N; ++i) {
            //System.out.println(DFS(i));
            if (DFS(i) == false) ++count;
        }
        return count;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int test = 0; test < T; ++test) {
            N = Integer.parseInt(reader.readLine());
            A = new int[N];
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < N; ++i)
                A[i] = Integer.parseInt(tokenizer.nextToken()) - 1;
            System.out.println(solution());
        }
    }
}