package baekjoon.p01.p1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1 {
    static int N, M;
    static int[] 부모, 크기;

    static int 루트찾기(int node) {
        while (부모[node] != -1)
            node = 부모[node];
        return node;
    }

    static void 합집합(int node1, int node2) {
        int 루트1 = 루트찾기(node1), 루트2 = 루트찾기(node2);
        if (루트1 == 루트2) return;
        if (크기[루트1] < 크기[루트2]) { int temp = 루트1; 루트1 = 루트2; 루트2 = temp; }
        부모[루트2] = 루트1;
        크기[루트1] += 크기[루트2];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken()) + 1;
        M = Integer.parseInt(tokenizer.nextToken());
        부모 = new int[N]; Arrays.fill(부모, -1);
        크기 = new int[N]; Arrays.fill(크기, 1);
        var builder = new StringBuilder();
        for (int i = 0; i < M; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int c = Integer.parseInt(tokenizer.nextToken());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            if (c == 0)
                합집합(a, b);
            else
                builder.append(루트찾기(a) == 루트찾기(b) ? "YES\n" : "NO\n");
        }
        System.out.println(builder.toString());
    }
}