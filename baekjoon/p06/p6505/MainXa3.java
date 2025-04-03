package baekjoon.p06.p6505;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainXa3 {
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

    static void encode(char[] x, char[] y, int[] p) {
        for (int i = 0; i < x.length; ++i)
            y[p[i]] = x[i];
    }

    static String solution(int n, int m, int[] p, String s) {
        char[] original = s.toCharArray();
        char[] x = new char[n], y = new char[n];
        System.arraycopy(original, 0, x, 0, n);
        m = m % 사이클크기_최소공배수(p);
        for (int i = 0; i < m; ++i) {
            encode(x, y, p);
            char[] temp = x;
            x = y;
            y = temp;
        }
        return new String(x);
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