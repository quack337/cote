package baekjoon.p01.p1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class IntArray {
        int[] a = new int[32];  // 최초 크기는 32
        int count = 0;          // a 배열의 데이터 수

        public void add(int value) {
            if (count == a.length) // a 배열이 꽉 찼으면
                a = Arrays.copyOf(a, a.length * 2); // 크기를 두 배 확장한다.
            a[count++] = value;
        }

        public int get(int i) {
            return a[i];
        }

        public int size() {
            return count;
        }
    }

    static IntArray[] 링크;
    static boolean[] 방문한노드;
    static int[] 신뢰수;
    static int N, M;

    static int DFS(int node) {
        방문한노드[node] = true;
        if (링크[node] == null) return 1;
        int 노드수 = 1;
        int size = 링크[node].size();
        for (int i = 0; i < size; ++i) {
            int c = 링크[node].get(i);
            if (방문한노드[c]) continue;
            노드수 += DFS(c);
        }
        return 노드수;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        링크 = new IntArray[N];
        신뢰수 = new int[N];
        방문한노드 = new boolean[N];
        for (int i = 0; i < M; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            if (링크[b] == null) 링크[b] = new IntArray();
            링크[b].add(a);
        }
        reader.close();

        int 최대값 = 0;
        for (int i = 0; i < N; ++i) {
            Arrays.fill(방문한노드, false);
            신뢰수[i] = DFS(i);
            if (신뢰수[i] > 최대값) 최대값 = 신뢰수[i];
        }
        var result = new StringBuilder();
        for (int i = 0; i < N; ++i)
            if (신뢰수[i] == 최대값) result.append(i + 1).append(' ');
        System.out.println(result);
    }
}
