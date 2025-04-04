package baekjoon.b06.p6505;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    static int 사이클찾기DFS(int[] p, int index, boolean[] visited, int size) {
        if (visited[index]) return size;
        visited[index] = true;
        return 사이클찾기DFS(p, p[index], visited, size + 1);
    }

    static int[] 사이클크기구하기(int[] p) {
        int[] 사이클크기 = new int[p.length];
        for (int i = 0; i < p.length; ++i)
            if (사이클크기[i] == 0) {
                boolean[] visited = new boolean[p.length];
                int 크기 = 사이클찾기DFS(p, i, visited, 0);
                for (int j = 0; j < p.length; ++j)
                    if (visited[j]) 사이클크기[j] = 크기;
            }
        return 사이클크기;
    }

    static String solution(int n, int m, int[] p, String s) {
        char[] result = new char[p.length];
        int[] 사이클크기 = 사이클크기구하기(p);
        for (int i = 0; i < p.length; ++i) {
            int index = i;
            for (int j = 0; j < m % 사이클크기[i]; ++j)
                index = p[index];
            result[index] = s.charAt(i);
        }
        return new String(result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());
            if (n == 0) break;
            int[] p = new int[n];
            tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; ++i)
                p[i] = Integer.parseInt(tokenizer.nextToken()) - 1;
            String s = reader.readLine();
            builder.append(solution(n, m, p, s)).append('\n');
        }
        reader.close();
        System.out.println(builder.toString());
    }

}