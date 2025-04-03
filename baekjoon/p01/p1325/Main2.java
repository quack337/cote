package baekjoon.p01.p1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {

    static class IntArray {
        int[] a = new int[32];
        int count = 0;

        private void expand() {
            a = Arrays.copyOf(a, a.length * 2);
        }

        public void add(int value) {
            if (count == a.length) expand();
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
    static int[] DP;
    static int N, M;
    static boolean 싸이클발견;

    static int DFS(int node) {
        if (방문한노드[node]) {
            싸이클발견 = true;
            return 0;
        }
        방문한노드[node] = true;
        if (DP[node] > 0) return DP[node];
        if (링크[node] == null) {
            if (싸이클발견 == false) DP[node] = 1;
            return 1;
        }
        int 노드수 = 1;
        int size = 링크[node].size();
        for (int i = 0; i < size; ++i) {
            int c = 링크[node].get(i);
            노드수 += DFS(c);
        }
        if (싸이클발견 == false) DP[node] = 노드수;
        return 노드수;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        링크 = new IntArray[N];
        신뢰수 = new int[N];
        DP = new int[N];
        방문한노드 = new boolean[N];
        for (int i = 0; i < M; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            if (링크[b] == null) 링크[b] = new IntArray();
            링크[b].add(a);
        }
        reader.close();

        Arrays.fill(방문한노드, false);
        싸이클발견 = false;
        System.out.println(DFS(2-1));

        Arrays.fill(방문한노드, false);
        싸이클발견 = false;
        System.out.println(DFS(4-1));

        Arrays.fill(방문한노드, false);
        싸이클발견 = false;
        System.out.println(DFS(15-1));

        Arrays.fill(방문한노드, false);
        싸이클발견 = false;
        System.out.println(DFS(16-1));

        Arrays.fill(방문한노드, false);
        싸이클발견 = false;
        System.out.println(DFS(18-1));

        Arrays.fill(방문한노드, false);
        싸이클발견 = false;
        System.out.println(DFS(19-1));

        /*
        int 최대값 = 0;
        for (int i = 0; i < N; ++i) {
            Arrays.fill(방문한노드, false);
            싸이클발견 = false;
            신뢰수[i] = DFS(i);
            if (신뢰수[i] > 최대값) 최대값 = 신뢰수[i];
        }
        for (int i = 0; i < N; ++i)
            if (신뢰수[i] == 최대값) System.out.printf("%d ", i + 1);
        System.out.println();

        System.out.println(Arrays.toString(DP));
        System.out.println(Arrays.toString(신뢰수));*/
    }
}