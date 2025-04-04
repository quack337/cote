package baekjoon.b06.p6505;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainXa2 {
    static int 최대공약수(int a, int b){
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static int 최소공배수(int a, int b) {
        return a * b / 최대공약수(a, b);
    }

    static int 사이클찾기DFS(int[] p, int index, boolean[] visited, int size) {
        if (visited[index]) return size;
        visited[index] = true;
        return 사이클찾기DFS(p, p[index], visited, size + 1);
    }

    static int 사이클크기_최소공배수(int[] p) {
        boolean[] visited = new boolean[p.length];
        int result = -1;
        for (int i = 0; i < p.length; ++i)
            if (visited[i] == false) {
                int 사이클크기 = 사이클찾기DFS(p, i, visited, 0);
                if (result == -1) result = 사이클크기;
                else result = 최소공배수(result, 사이클크기);
            }
        return result;
    }

    static char[] encode(char[] x, int[] p) {
        char[] y = new char[x.length];
        for (int i = 0; i < x.length; ++i)
            y[p[i]] = x[i];
        return y;
    }

    static String solution(int n, int m, int[] p, String s) {
        m = m % 사이클크기_최소공배수(p);
        char[] x = s.toCharArray();
        for (int i = 0; i < m; ++i)
            x = encode(x, p);
        return new String(x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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
            System.out.println(solution(n, m, p, s));
        }
        reader.close();
    }

}